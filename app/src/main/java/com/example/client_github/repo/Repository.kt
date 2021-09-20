package com.example.client_github.repo

import com.example.client_github.model.GithubUser

class Repository {
    private val users = listOf(
        GithubUser("user1"),
        GithubUser("user2"),
        GithubUser("user3"),
        GithubUser("user4"),
        GithubUser("user5")
    )

    fun getUsers() = users
}