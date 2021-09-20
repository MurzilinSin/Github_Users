package com.example.client_github.presentation

import com.example.client_github.repo.Repository
import com.example.client_github.view.ui.usersList.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserDetailPresenter(
    private val repo: Repository,
    private val router: Router
): MvpPresenter<UsersView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}