package com.example.client_github.presentation

import com.example.client_github.model.GithubUser
import com.example.client_github.repo.Repository
import com.example.client_github.screens.AndroidScreens
import com.example.client_github.view.ui.usersList.UserItemView
import com.example.client_github.view.ui.usersList.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(
    private val repo: Repository,
    private val router: Router): MvpPresenter<UsersView>() {
    class UsersListPresenter: IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.showLogin(user.login)
        }

        override fun getCount(): Int  = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(AndroidScreens.userDetailScreen(usersListPresenter.users[itemView.pos].login))
        }
    }

    fun loadData() {
        val users = repo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}