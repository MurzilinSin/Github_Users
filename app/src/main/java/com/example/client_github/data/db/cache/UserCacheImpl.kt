package com.example.client_github.data.db.cache

import com.example.client_github.data.GithubUser
import com.example.client_github.data.db.GithubDatabase
import com.example.client_github.data.db.RoomGithubUser
import javax.inject.Inject

class UserCacheImpl @Inject constructor(private val db: GithubDatabase): UserCache {
    override fun remoteToDB(githubUsers: List<GithubUser>): List<RoomGithubUser> {
        val roomUsers = githubUsers.map { user ->
            RoomGithubUser(
                user.id.toString(),
                user.login.orEmpty(),
                user.avatarUrl.orEmpty(),
                user.reposUrl.orEmpty()
            )
        }
        db.userDao.insert(roomUsers)
        return roomUsers
    }

    override fun fromRemote(): List<GithubUser> {
        return db.userDao.getAll().map { roomUser ->
            GithubUser(
                login = roomUser.login,
                id = roomUser.id.toLong(),
                avatarUrl = roomUser.avatarUrl,
                reposUrl = roomUser.reposUrl
            )
        }
    }
}