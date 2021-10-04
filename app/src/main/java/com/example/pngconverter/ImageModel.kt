package com.example.pngconverter

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import java.io.File
import java.io.FileOutputStream
import java.lang.RuntimeException

class ImageModel {
    @RequiresApi(Build.VERSION_CODES.P)
    fun convert(filesDir: File,resources: Resources): Completable = Completable.create {
        Thread.sleep(5000L)
        val jpeg = File(filesDir,"yourImage.png")
        val output = FileOutputStream(jpeg)
        val source = ImageDecoder.createSource(resources,R.drawable.obito)
        val bitmap = ImageDecoder.decodeBitmap(source)
        bitmap.compress(Bitmap.CompressFormat.PNG,100,output)
        output.flush()
        output.close()
    }
}