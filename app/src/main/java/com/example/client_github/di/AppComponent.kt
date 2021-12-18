package com.example.client_github.di

import com.example.client_github.ui.activity.MainActivity
import com.example.client_github.ui.activity.MainPresenter
import com.example.client_github.ui.screens.fork.ForkPresenter
import com.example.client_github.ui.screens.repos.RepoPresenter
import com.example.client_github.ui.screens.users.UsersPresenter
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CacheModule::class,
        CiceroneModule::class,
    ]
)

interface AppComponent {

    fun presenter(): MainPresenter
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(reposPresenter: RepoPresenter)
    fun inject(forkPresenter: ForkPresenter)
}