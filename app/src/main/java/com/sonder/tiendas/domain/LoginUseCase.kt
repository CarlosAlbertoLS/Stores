package com.sonder.tiendas.domain

import com.sonder.tiendas.data.network.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(emil:String, password:String){
        return repository.login(emil, password)
    }
}