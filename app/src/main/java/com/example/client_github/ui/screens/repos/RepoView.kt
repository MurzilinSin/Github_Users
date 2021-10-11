package com.example.client_github.ui.screens.repos

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface RepoView: MvpView {
    fun init()
    fun updateList()
}