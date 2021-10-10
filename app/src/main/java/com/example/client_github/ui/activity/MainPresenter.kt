package com.example.client_github.ui.activity

import com.example.client_github.navigation.AndroidScreens
import com.example.client_github.ui.activity.MainView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AndroidScreens.usersScreen())
    }
    fun backPressed() {
        router.exit()
    }
}