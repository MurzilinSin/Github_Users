package com.example.client_github.ui.screens.users

import com.example.client_github.data.GithubUser
import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.navigation.AndroidScreens
import com.example.client_github.presentation.IUserListPresenter
import com.example.client_github.ui.screens.users.adapter.UserItemView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(
    private val repo: GithubUsersRepo,
    private val router: Router): MvpPresenter<UsersView>() {
    class UsersListPresenter: IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.showLogin(user.login.orEmpty())
            view.showAvatar(user.avatarUrl.orEmpty())
        }

        override fun getCount(): Int  = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(AndroidScreens.reposScreen(usersListPresenter.users[itemView.pos].login.orEmpty()))
        }
    }

    private fun loadData() {
       repo.getUsers()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe ({ users ->
               usersListPresenter.users.addAll(users)
               viewState.updateList()
           },{

           })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}