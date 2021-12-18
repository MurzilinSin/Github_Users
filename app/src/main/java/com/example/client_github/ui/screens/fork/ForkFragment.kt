package com.example.client_github.ui.screens.fork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.client_github.App
import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.data.db.GithubDatabase
import com.example.client_github.data.db.cache.UserCacheImpl
import com.example.client_github.databinding.FragmentForkBinding
import com.example.client_github.navigation.BackButtonListener
import com.example.client_github.utils.AndroidNetworkStatus
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ForkFragment: MvpAppCompatFragment(), ForkView, BackButtonListener {
    private var _binding: FragmentForkBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter {
        ForkPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentForkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun init() {
        val text = "Count of forks: ${requireArguments().getInt("forkCount")}"
        binding.forks.text = text
    }

    override fun updateList() {}

    companion object {
        fun newInstance(forkCount: Int): ForkFragment {
        return ForkFragment().apply {
                arguments = bundleOf(FORK_COUNT to forkCount)
            }
        }
        private const val FORK_COUNT = "forkCount"
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}