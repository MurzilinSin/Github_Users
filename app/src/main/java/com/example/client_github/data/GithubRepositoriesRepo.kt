package com.example.client_github.data

import com.example.client_github.data.db.cache.RepoCacheImpl
import com.example.client_github.remote.ApiHolder
import com.example.client_github.utils.INetworkStatus
import io.reactivex.rxjava3.core.Single

class GithubRepositoriesRepo(
    private val networkStatus: INetworkStatus,
    private val reposCache: RepoCacheImpl
) {
    fun getRepo(name: String) = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if(isOnline){
            ApiHolder.apiService.getUserRepos(name).flatMap { repos ->
                Single.fromCallable{
                    reposCache.remoteToDB(repos,name)
                    repos
                }
            }
        } else {
            Single.fromCallable{
                reposCache.fromRemote(name)
            }
        }
    }
}