package com.sonder.tiendas.ui.signin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sonder.tiendas.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    companion object {
        fun create(context: Context) = Intent(context, SignInActivity::class.java)
    }
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}