package com.sonder.tiendas.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: StoresApi) {
    suspend fun doLogin(email: String, password: String){
        return withContext(Dispatchers.IO){
            loginClient.loginUser(email, password)
        }
    }
}