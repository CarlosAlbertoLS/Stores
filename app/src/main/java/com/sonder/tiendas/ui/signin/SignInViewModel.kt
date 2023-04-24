package com.sonder.tiendas.ui.signin

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonder.tiendas.data.network.utils.SessionManager
import com.sonder.tiendas.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
    ): ViewModel() {
    val isLoading: MutableLiveData<Int> = MutableLiveData(View.VISIBLE)

    fun onSignInSelected(email: String, password: String, name: String, context: Context){
        viewModelScope.launch {
            isLoading.postValue(View.VISIBLE)
            val responseSignIn = signInUseCase(email, password, name)
            val myResponse = responseSignIn.body()
            if (myResponse != null){
                SessionManager.saveAuthToken(context = context, token = myResponse.token)
            }
            isLoading.postValue(View.GONE)
        }
    }
}