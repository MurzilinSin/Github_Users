package com.example.client_github.data

import com.example.client_github.data.db.cache.UserCache
import com.example.client_github.data.db.cache.UserCacheImpl
import com.example.client_github.remote.IApiHolder
import com.example.client_github.utils.INetworkStatus
import dagger.Provides
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersRepo @Inject constructor(
    private val apiHolder: IApiHolder,
    private val networkStatus: INetworkStatus,
    private val userCache: UserCacheImpl
) {
    fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            apiHolder.apiService.getUsers()
                .flatMap { users ->
                    Single.fromCallable {
                        userCache.remoteToDB(users)
                        users
                    }
                }
        } else {
            Single.fromCallable {
                userCache.fromRemote()
            }
        }
    }
}