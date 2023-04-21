package com.sonder.tiendas.data.network

import com.sonder.tiendas.data.network.utils.Constants
import com.sonder.tiendas.data.network.model.StoresResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface StoresApi {
    @POST(Constants.API_PATH_LOGIN)
    suspend fun loginUser(
        @Query("email") email:String,
        @Query("password") password:String
    ): Response<StoresResponse>

    @POST(Constants.API_PATH_SIGNING)
    suspend fun registerUser(
        @Query("email") email:String,
        @Query("password") password:String,
        @Query("name") name: String
    )
}