package com.example.client_github.ui.screens.userDetail

import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.ui.screens.users.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserDetailPresenter(
    private val repo: GithubUsersRepo,
    private val router: Router
): MvpPresenter<UsersView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}