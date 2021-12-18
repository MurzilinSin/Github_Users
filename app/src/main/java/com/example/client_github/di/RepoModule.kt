package com.example.client_github.di

import com.example.client_github.data.GithubRepositoriesRepo
import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.data.db.cache.RepoCacheImpl
import com.example.client_github.data.db.cache.UserCacheImpl
import com.example.client_github.remote.ApiHolder
import com.example.client_github.utils.INetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(
        api: ApiHolder,
        networkStatus: INetworkStatus,
        cache: UserCacheImpl
    ): GithubUsersRepo = GithubUsersRepo(
        apiHolder = api,
        networkStatus = networkStatus,
        userCache = cache
    )

    @Singleton
    @Provides
    fun reposRepo(
        api: ApiHolder,
        networkStatus: INetworkStatus,
        cache: RepoCacheImpl,

        ): GithubRepositoriesRepo = GithubRepositoriesRepo(
        apiHolder = api,
        networkStatus = networkStatus,
        reposCache = cache

    )
}