package com.example.client_github.ui.activity

import com.example.client_github.navigation.AndroidScreens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(private val router: Router) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AndroidScreens.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}