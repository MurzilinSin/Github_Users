package com.example.client_github.presentation

import com.example.client_github.ui.items.IItemView
import com.example.client_github.ui.screens.repos.adapter.RepoItemView
import com.example.client_github.ui.screens.users.adapter.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>
interface IReposListPresenter : IListPresenter<RepoItemView>