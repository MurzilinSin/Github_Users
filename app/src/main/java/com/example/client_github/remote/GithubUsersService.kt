package com.example.client_github.remote

import com.example.client_github.data.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GithubUsersService {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>
}