package com.sonder.tiendas.data.network.model

import com.google.gson.annotations.SerializedName

data class StoresResponse(
    @SerializedName("status") val status: String
)
