package com.sonder.tiendas.data.network

import com.sonder.tiendas.data.network.utils.Constants
import com.sonder.tiendas.data.network.model.StoresResponse
import com.sonder.tiendas.data.network.model.UserBody
import com.sonder.tiendas.data.network.model.UserLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface StoresApi {
    @POST(Constants.API_PATH_LOGIN)
    suspend fun loginUser(
        @Body userLogin: UserLogin
    ): Response<StoresResponse>

    @POST(Constants.API_PATH_SIGNING)
    suspend fun registerUser(
        @Body userBody: UserBody
    ): Response<StoresResponse>
}