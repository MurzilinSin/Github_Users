package com.example.client_github.di

import android.content.Context
import androidx.room.Room
import com.example.client_github.data.db.GithubDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun db(context: Context): GithubDatabase {
        return  Room.databaseBuilder(context, GithubDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {

        private const val DB_NAME = "githubDatabase.db"

    }
}