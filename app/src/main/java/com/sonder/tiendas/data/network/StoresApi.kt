package com.sonder.tiendas.data.network

import android.telecom.Call
import com.sonder.tiendas.data.network.model.StoresResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StoresApi {
    @GET(".")
    suspend fun loginUser(
        @Query("email") email:String,
        @Query("password") password:String
    ): Response<StoresResponse>
}