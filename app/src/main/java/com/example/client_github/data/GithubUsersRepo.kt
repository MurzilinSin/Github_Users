package com.example.client_github.data

import com.example.client_github.data.db.cache.UserCacheImpl
import com.example.client_github.remote.ApiHolder
import com.example.client_github.utils.INetworkStatus
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo(
    private val networkStatus: INetworkStatus,
    private val userCache: UserCacheImpl
) {
    fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if(isOnline){
            ApiHolder.apiService.getUsers()
                .flatMap { users ->
                    Single.fromCallable{
                        userCache.remoteToDB(users)
                        users
                    }
                }
        } else {
            Single.fromCallable{
               userCache.fromRemote()
            }
        }
    }
}