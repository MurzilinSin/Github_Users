package com.example.client_github.navigation

import com.example.client_github.ui.screens.users.UsersFragment
import com.example.client_github.ui.screens.userDetail.UserDetailFragment
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