package com.example.android4_lesson1

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView: MvpView {
    fun setButtonOneText(text: String)
    fun setButtonTwoText(text: String)
    fun setButtonThreeText(text: String)
}