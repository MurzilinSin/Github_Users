package com.example.client_github.ui.screens.repos

import com.example.client_github.data.UserRepos
import com.example.client_github.data.GithubRepositoriesRepo
import com.example.client_github.navigation.AndroidScreens
import com.example.client_github.presentation.IReposListPresenter
import com.example.client_github.ui.screens.repos.adapter.RepoItemView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import java.lang.NullPointerException

class RepoPresenter(
    private val repo: GithubRepositoriesRepo,
    private val router: Router): MvpPresenter<RepoView>() {
    class ReposListPresenter: IReposListPresenter{
        val repos = mutableListOf<UserRepos>()

        override var itemClickListener: ((RepoItemView) -> Unit)? = null

        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            view.showRepoName(repo.name.orEmpty())
        }

        override fun getCount(): Int = repos.size
    }

    val reposListPresenter = ReposListPresenter()
    var login: String? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        println("TYT " + login)
        if (!login.isNullOrBlank()){
            println("A TEPER TYT")
            loadData(login!!)
            reposListPresenter.itemClickListener = { itemView ->
                router.navigateTo(AndroidScreens.forkScreen(reposListPresenter.repos[itemView.pos].forks))
            }
        }
    }

    private fun loadData(login: String) {
        repo.getRepo(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ repos ->
                println("REPOS " + repos)
                reposListPresenter.repos.addAll(repos)
                viewState.updateList()
            }, {
                Throwable("Error",NullPointerException())
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}