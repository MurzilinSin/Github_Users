package com.example.client_github.ui.screens.fork

import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.ui.screens.users.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ForkPresenter: MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}