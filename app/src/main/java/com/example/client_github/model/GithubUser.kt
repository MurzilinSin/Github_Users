package com.example.client_github.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val login: String
):Parcelable {
    fun getUsers(){}
}