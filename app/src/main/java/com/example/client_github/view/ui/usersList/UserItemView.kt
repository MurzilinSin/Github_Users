package com.example.client_github.view.ui.usersList

import com.example.client_github.view.IItemView

interface UserItemView: IItemView {
    fun showLogin(login: String)
}