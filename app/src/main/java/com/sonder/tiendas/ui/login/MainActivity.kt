package com.sonder.tiendas.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.tiendas.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}