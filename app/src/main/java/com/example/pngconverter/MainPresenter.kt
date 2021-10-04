package com.example.pngconverter

import android.content.res.Resources
import android.os.Build
import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.io.File
import java.util.concurrent.TimeUnit

class MainPresenter(private val image: ImageModel): MvpPresenter<MainView>() {
    @RequiresApi(Build.VERSION_CODES.P)
    fun convert(filesDir: File, resources: Resources) {
        image.convert(filesDir, resources)
            .subscribeOn(Schedulers.computation())
            .observeOn(mainThread())
            .subscribe()
        viewState.convertToPng(R.drawable.obito)

    }
}