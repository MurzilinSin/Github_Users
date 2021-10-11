package com.example.client_github.ui.images

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader: IImageLoader<ImageView> {

    override fun loadTo(url: String, imageHolder: ImageView) {
        Glide.with(imageHolder.context)
            .load(url)
            .into(imageHolder)
    }
}