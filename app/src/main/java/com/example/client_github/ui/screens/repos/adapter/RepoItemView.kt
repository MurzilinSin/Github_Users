package com.example.client_github.ui.screens.repos.adapter

import com.example.client_github.ui.items.IItemView

interface RepoItemView: IItemView {
    fun showRepoName(name: String)
}