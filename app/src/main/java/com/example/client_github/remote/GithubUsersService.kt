package com.example.client_github.remote

import com.example.client_github.data.GithubUser
import com.example.client_github.data.UserRepos
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface GithubUsersService {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("/users/{name}/repos")
    fun getUserRepos(@Path("name") name: String): Single<List<UserRepos>>
}