package com.sonder.tiendas.data.network

import com.sonder.tiendas.data.network.model.StoresResponse
import com.sonder.tiendas.data.network.model.UserBody
import com.sonder.tiendas.data.network.model.UserLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: StoresApi) {
    suspend fun doLogin(email: String, password: String){
        return withContext(Dispatchers.IO){
            loginClient.loginUser(UserLogin(email, password))
        }
    }

    suspend fun doSignIn(email: String, password: String, name: String):Response<StoresResponse>{
        return withContext(Dispatchers.IO){
            loginClient.registerUser(UserBody(email, password, name))
        }
    }
}