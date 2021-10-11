package com.example.client_github.ui.images

interface IImageLoader<T> {
    fun loadTo(url: String, imageHolder: T)
}