package com.example.client_github.ui.activity

import android.os.Bundle
import com.example.client_github.R
import com.example.client_github.databinding.ActivityMainBinding
import com.example.client_github.navigation.BackButtonListener
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView {
    private val navigator = SupportAppNavigator(this, R.id.container)
    private var _bind: ActivityMainBinding? = null
    private val bind get() = _bind!!
    private val presenter by moxyPresenter { MainPresenter(com.example.client_github.App.instance.router)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        com.example.client_github.App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        com.example.client_github.App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backPressed()
    }
}