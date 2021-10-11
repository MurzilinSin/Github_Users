package com.example.client_github.data

import com.example.client_github.data.GithubUser
import com.example.client_github.remote.ApiHolder
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable

class GithubUsersRepo {
    fun getUsers() = ApiHolder.apiService.getUsers()
    fun getRepo(name: String) = ApiHolder.apiService.getUserRepos(name)
}