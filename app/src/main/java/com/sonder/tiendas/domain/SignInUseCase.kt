package com.sonder.tiendas.domain

import com.sonder.tiendas.data.network.model.StoresResponse
import com.sonder.tiendas.data.network.repository.LoginRepository
import com.sonder.tiendas.data.network.repository.SignInRepository
import retrofit2.Response
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val repository: SignInRepository) {
    suspend operator fun invoke(email: String, password:String, name: String):Response<StoresResponse>{
        return repository.signIn(email, password, name)
    }
}