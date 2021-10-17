package com.example.client_github.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.lang.IllegalStateException

@Database(
    entities = [RoomGithubUser::class, RoomGithubRepo::class],
    version = 1
)
abstract class GithubDatabase: RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repoDao: RepoDao

    companion object {
        private const val DB_NAME = "githubDatabase.db"
        private var instance: GithubDatabase? = null

        fun getInstance() = instance ?: throw IllegalStateException("А база ты ненастоящая")

        fun create(context: Context) {
            if(instance == null) {
                instance = Room.databaseBuilder(context, GithubDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }
}