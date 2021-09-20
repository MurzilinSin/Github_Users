package com.example.client_github.screens

import com.example.client_github.view.ui.usersList.UsersFragment
import com.example.client_github.view.ui.user.UserDetailFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object AndroidScreens {
    fun usersScreen(): SupportAppScreen {
        return object: SupportAppScreen(){
            override fun getFragment() = UsersFragment()
        }
    }

    fun userDetailScreen(login: String): SupportAppScreen {
        return object: SupportAppScreen(){
            override fun getFragment() = UserDetailFragment.newInstance(login)
        }
    }
}