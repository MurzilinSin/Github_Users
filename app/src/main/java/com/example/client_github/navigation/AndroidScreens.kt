package com.example.client_github.navigation

import com.example.client_github.ui.screens.repos.RepoFragment
import com.example.client_github.ui.screens.users.UsersFragment
import com.example.client_github.ui.screens.fork.ForkFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object AndroidScreens {
    fun usersScreen(): SupportAppScreen {
        return object: SupportAppScreen(){
            override fun getFragment() = UsersFragment()
        }
    }

    fun reposScreen(login: String): SupportAppScreen {
        return object : SupportAppScreen(){
            override fun getFragment() = RepoFragment.newInstance(login)
        }
    }

    fun forkScreen(forkCount: Int): SupportAppScreen {
        return object: SupportAppScreen(){
            override fun getFragment() = ForkFragment.newInstance(forkCount)
        }
    }
}