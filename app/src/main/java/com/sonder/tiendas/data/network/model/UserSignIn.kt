package com.sonder.tiendas.data.network.model

import com.google.gson.annotations.SerializedName

data class UserSignIn(
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
    @SerializedName("password") val password: String
)
