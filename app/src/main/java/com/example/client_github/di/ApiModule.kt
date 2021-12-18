package com.example.client_github.di

import android.content.Context
import com.example.client_github.remote.ApiHolder
import com.example.client_github.remote.GithubUsersService
import com.example.client_github.remote.IApiHolder
import com.example.client_github.utils.AndroidNetworkStatus
import com.example.client_github.utils.INetworkStatus
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
interface ApiModule {

    /*@Binds
    fun abc(impl: ApiHolder): IApiHolder*/

    companion object {

        @Singleton
        @Provides
        @Named("baseUrl")
        fun baseUrl(): String = "https://api.github.com/"

        @Provides
        @Singleton
        fun gson(): Gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        @Provides
        fun githubUsersService(@Named("baseUrl") baseUrl: String, gson: Gson): GithubUsersService {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(GithubUsersService::class.java)
        }

        @Provides
        @Singleton
        fun apiHolder(apiService: GithubUsersService): IApiHolder {
            return ApiHolder(apiService = apiService)
        }

        @Provides
        @Singleton
        fun networkStatus(context: Context): INetworkStatus =
            AndroidNetworkStatus(context)
    }

}