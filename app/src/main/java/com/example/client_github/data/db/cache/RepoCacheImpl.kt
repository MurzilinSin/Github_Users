package com.example.client_github.data.db.cache

import com.example.client_github.data.UserRepos
import com.example.client_github.data.db.GithubDatabase
import com.example.client_github.data.db.RoomGithubRepo

class RepoCacheImpl(val db: GithubDatabase): RepoCache {

    override fun remoteToDB(repos: List<UserRepos>, name: String): List<RoomGithubRepo> {
        val roomUser = db.userDao.getByLogin(name)
        val roomRepos = repos.map { repo ->
            RoomGithubRepo(
                id = repo.id,
                name = repo.name.orEmpty(),
                forksCount = repo.forks,
                userId = roomUser.id
            )
        }
        db.repoDao.insert(roomRepos)
        return roomRepos
    }

    override fun fromRemote(name: String): List<UserRepos> {
        val roomUser = db.userDao.getByLogin(name)
        return db.repoDao.getByUserId(roomUser.id).map {
            UserRepos(it.id,it.name,it.forksCount)
        }
    }
}