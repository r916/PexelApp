package com.example.pexelapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.pexelapp.R
import com.example.pexelapp.viewmodel.PexelViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: PexelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}