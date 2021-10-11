package com.example.client_github.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserRepos(
    @Expose
    val id: String,

    @Expose
    val name: String? = null,

    @Expose
    val forks: Int
): Parcelable