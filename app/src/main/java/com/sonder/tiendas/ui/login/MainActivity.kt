package com.sonder.tiendas.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sonder.tiendas.R
import com.sonder.tiendas.data.network.utils.SessionManager
import com.sonder.tiendas.databinding.ActivityMainBinding
import com.sonder.tiendas.ui.listStores.StoresActivity
import com.sonder.tiendas.ui.signin.SignInActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        fun create(context: Context) = Intent(context, MainActivity::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainActivityViewModel>()
    //private var email: String by viewModel.email.observe(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val token = SessionManager.getToken(this)
        if (!token.isNullOrBlank()) {
            navigateToHome()
        }

        /*viewModel.loginResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }
                else -> {
                    stopLoading()
                }
            }
        }*/

        binding.btnLogin.setOnClickListener {
            doLogin()
        }

        binding.tvCreateAccount.setOnClickListener {
            openSignIn()
        }
    }

    private fun navigateToHome() = startActivity(MainActivity.create(this@MainActivity))

    fun doLogin() {
        val email = binding.etEmail.text.toString() ?: ""
        val password = binding.etPassword.text.toString() ?: ""
        if (viewModel.enableLogin(email, password)){
            viewModel.onLoginChanged(email, password)
            openStoresList()
        }else {
            errorMessage()
        }
    }

    private fun errorMessage() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.dialog_title)
            .setPositiveButton(R.string.dialog_confirm, null)
            .setNegativeButton(R.string.dialog_cancel, null)
            .show()
    }

    private fun openStoresList() = startActivity(StoresActivity.create(this@MainActivity))

    private fun openSignIn() = startActivity(SignInActivity.create(this@MainActivity))
}
