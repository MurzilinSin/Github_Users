package com.example.client_github.ui.screens.users.adapter

import com.example.client_github.ui.items.IItemView

interface UserItemView: IItemView {
    fun showLogin(login: String?)
}