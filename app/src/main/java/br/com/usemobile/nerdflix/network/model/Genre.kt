package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("key")
    val key: String
)
