package com.sonder.tiendas.ui.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sonder.tiendas.databinding.ActivitySignInBinding
import com.sonder.tiendas.ui.listStores.StoresActivity
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
        viewModel.onSignInSelected(email, password, name, this@SignInActivity)
        startActivity(StoresActivity.createStores(this@SignInActivity))
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