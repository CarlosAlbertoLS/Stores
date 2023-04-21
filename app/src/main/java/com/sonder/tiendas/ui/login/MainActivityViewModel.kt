package com.sonder.tiendas.ui.login

import android.content.Context
import android.util.Patterns
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonder.tiendas.domain.LoginUseCase
import com.sonder.tiendas.ui.listStores.StoresActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isLoginEnable = MutableLiveData<Boolean>()
    private val _isLoading = MutableLiveData<Boolean>()
    val email : LiveData<String> = _email
    val password : LiveData<String> = _password
    val isLoginEnable : LiveData<Boolean> = _isLoginEnable
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email : String, password : String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun enableLogin(email:String, password:String):Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length == 8

    fun onLoginSelected(email: String, password: String){
        viewModelScope.launch {
            loginUseCase(email, password)
        }
    }
}