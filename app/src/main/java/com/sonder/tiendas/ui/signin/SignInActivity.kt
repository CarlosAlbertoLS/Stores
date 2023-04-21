package com.sonder.tiendas.ui.signin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.sonder.tiendas.data.network.model.StoresResponse
import com.sonder.tiendas.data.network.utils.Constants
import com.sonder.tiendas.data.network.utils.SessionManager
import com.sonder.tiendas.databinding.ActivitySignInBinding
import com.sonder.tiendas.ui.listStores.StoresActivity
import com.sonder.tiendas.ui.login.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    companion object {
        fun createSignIn(context: Context) = Intent(context, SignInActivity::class.java)
    }
    private lateinit var binding: ActivitySignInBinding
    private val viewModel by viewModels<SignInViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
      binding.btnSignIn.setOnClickListener {
          doSignIn()
      }
    }

    private fun doSignIn() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val name = binding.etName.text.toString().trim()
        viewModel.isLoading.observe(this) { visibility ->
            binding.pbCreateUser.visibility = visibility
        }
        viewModel.onSignInSelected(email, password, name)
        /*viewModel.responseToken.observe(this){tokenResponse ->
            Log.i("signin", tokenResponse.token)
        }*/
        Log.i("signin", "$email, $password, $name")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                this@SignInActivity.onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> { false }
        }
    }
}