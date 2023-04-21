package com.sonder.tiendas.data.network.repository

import com.sonder.tiendas.data.network.LoginService
import com.sonder.tiendas.data.network.model.StoresResponse
import retrofit2.Response
import javax.inject.Inject

class SignInRepository @Inject constructor(private val api: LoginService) {
    suspend fun signIn(email: String, password: String, name: String): Response<StoresResponse> {
        return api.doSignIn(email, password, name)
    }
}