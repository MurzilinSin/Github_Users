package com.example.client_github.repo

import com.example.client_github.model.GithubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable
import java.util.*

class Repository {
    private val users = listOf(
        GithubUser("user1"),
        GithubUser("user2"),
        GithubUser("user3"),
        GithubUser("user4"),
        GithubUser("user5")
    )

    private val usersSecond = listOf(
        GithubUser("user1"),
        GithubUser("user2"),
        GithubUser("user3"),
        GithubUser("user4"),
        GithubUser("user5")
    ).toObservable()

    fun getUsers(): Observable<List<GithubUser>>? = Observable.just(users)
    fun getUsersFromIterable(): Observable<GithubUser>? = Observable.fromIterable(users)
    fun getObservableUsers() = usersSecond
}