package com.sonder.tiendas.data.network.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

data class UserBody(
    @SerializedName("email") val email:String,
    @SerializedName("password") val password:String,
    @SerializedName("name") val name: String
)