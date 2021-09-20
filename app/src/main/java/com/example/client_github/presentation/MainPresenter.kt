package com.example.client_github.presentation

import com.example.client_github.screens.AndroidScreens
import com.example.client_github.view.MainView
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