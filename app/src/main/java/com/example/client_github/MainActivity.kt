package com.example.client_github

import android.os.Bundle
import com.example.client_github.App.App
import com.example.client_github.databinding.ActivityMainBinding
import com.example.client_github.presentation.MainPresenter
import com.example.client_github.view.BackButtonListener
import com.example.client_github.view.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView {
    private val navigator = SupportAppNavigator(this,R.id.container)
    private var _bind: ActivityMainBinding? = null
    private val bind get() = _bind!!
    private val presenter by moxyPresenter { MainPresenter(App.instance.router)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
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