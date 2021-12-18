package com.example.client_github

import android.app.Application
import com.example.client_github.data.db.GithubDatabase
import com.example.client_github.di.AppComponent
import com.example.client_github.di.AppModule
import com.example.client_github.di.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}