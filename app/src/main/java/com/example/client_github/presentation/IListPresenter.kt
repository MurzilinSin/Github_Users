package com.example.client_github.presentation

import com.example.client_github.view.IItemView
import com.example.client_github.view.ui.usersList.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>