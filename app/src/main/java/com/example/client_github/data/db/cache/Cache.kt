package com.example.client_github.data.db.cache

import com.example.client_github.data.GithubUser
import com.example.client_github.data.UserRepos
import com.example.client_github.data.db.RoomGithubRepo
import com.example.client_github.data.db.RoomGithubUser

interface UserCache {
    fun remoteToDB(githubUsers: List<GithubUser>) : List<RoomGithubUser>
    fun fromRemote() : List<GithubUser>
}

interface RepoCache {
    fun remoteToDB(githubUsers: List<UserRepos>, name: String) : List<RoomGithubRepo>
    fun fromRemote(name: String) : List<UserRepos>
}