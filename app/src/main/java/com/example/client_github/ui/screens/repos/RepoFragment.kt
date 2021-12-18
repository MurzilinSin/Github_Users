package com.example.client_github.ui.screens.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client_github.App
import com.example.client_github.data.GithubRepositoriesRepo
import com.example.client_github.data.db.GithubDatabase
import com.example.client_github.data.db.cache.RepoCacheImpl
import com.example.client_github.databinding.FragmentRepoBinding
import com.example.client_github.navigation.BackButtonListener
import com.example.client_github.ui.screens.repos.adapter.RepoRVAdapter
import com.example.client_github.utils.AndroidNetworkStatus
import com.example.client_github.utils.INetworkStatus
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoFragment : MvpAppCompatFragment(), RepoView, BackButtonListener {
    private var _bind: FragmentRepoBinding? = null
    private val bind get() = _bind!!
    private val presenter by moxyPresenter {
        RepoPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }
    private val adapter by lazy {
        RepoRVAdapter(presenter.reposListPresenter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bind = FragmentRepoBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun init() {
        presenter.login = requireArguments().getString(LOGIN)
        bind.repoRecycler.layoutManager = LinearLayoutManager(requireContext())
        bind.repoRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    companion object {
        fun newInstance(login: String): RepoFragment {
            return RepoFragment().apply {
                arguments = bundleOf(LOGIN to login)
            }
        }

        private const val LOGIN = "login"
    }
}