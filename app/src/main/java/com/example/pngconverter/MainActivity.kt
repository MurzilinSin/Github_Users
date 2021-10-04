package com.example.pngconverter

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.pngconverter.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(),MainView {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter {
        MainPresenter(ImageModel())
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.conversion.setOnClickListener {
            presenter.convert(filesDir,resources)
        }
    }

    override fun convertToPng(image: Int) {
        binding.image.setImageResource(image)
    }
}