package com.example.client_github.ui.screens.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client_github.App
import com.example.client_github.databinding.FragmentUsersBinding
import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.navigation.BackButtonListener
import com.example.client_github.ui.screens.users.adapter.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment: MvpAppCompatFragment(), UsersView, BackButtonListener {
    private var _bind: FragmentUsersBinding? = null
    private val bind get() = _bind!!
    private val presenter by moxyPresenter { UsersPresenter(GithubUsersRepo(), com.example.client_github.App.instance.router) }
    private val adapter by lazy { UsersRVAdapter(presenter.usersListPresenter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bind = FragmentUsersBinding.inflate(inflater,container,false)
        return bind.root
    }

    override fun init() {
        bind.recycler.layoutManager = LinearLayoutManager(requireContext())
        bind.recycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bind = null
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}