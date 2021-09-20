package com.example.android4_lesson1

import android.os.Bundle
import com.example.android4_lesson1.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private var _bind: ActivityMainBinding? = null
    private val bind get() = _bind!!
    private val presenter by moxyPresenter {
       MainPresenter(CountersModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnCounter1.setOnClickListener{presenter.counterOneClick()}
        bind.btnCounter2.setOnClickListener{presenter.counterTwoClick()}
        bind.btnCounter3.setOnClickListener{presenter.counterThreeClick()}
    }

    override fun setButtonOneText(text: String) {
        bind.btnCounter1.text = text
    }
    override fun setButtonTwoText(text: String) {
        bind.btnCounter2.text = text
    }
    override fun setButtonThreeText(text: String) {
        bind.btnCounter3.text = text
    }
}