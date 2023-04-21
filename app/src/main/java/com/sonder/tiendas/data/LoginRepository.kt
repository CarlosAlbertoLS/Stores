package com.sonder.tiendas.data

import com.sonder.tiendas.core.NetworkModule
import com.sonder.tiendas.data.network.LoginService
import com.sonder.tiendas.data.network.StoresApi
import com.sonder.tiendas.data.network.model.StoresResponse
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService){
    suspend fun login(email: String, password: String) {
        return api.doLogin(email, password)
    }
}