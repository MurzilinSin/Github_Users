package com.example.client_github.ui.screens.userDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.client_github.databinding.FragmentUserDetailBinding
import com.example.client_github.data.GithubUsersRepo
import com.example.client_github.navigation.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailFragment: MvpAppCompatFragment(), UserView, BackButtonListener {
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter {
        UserDetailPresenter(GithubUsersRepo(), com.example.client_github.App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentUserDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun init() {
        binding.userLogin.text = requireArguments().getString("KEY")
    }

    override fun updateList() {}

    companion object {
        fun newInstance(login: String): UserDetailFragment {
        return UserDetailFragment().apply {
                arguments = bundleOf(KEY_ARG to login)
            }
        }
        private const val KEY_ARG = "KEY"
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}