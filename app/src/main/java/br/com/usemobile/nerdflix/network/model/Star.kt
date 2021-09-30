package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class Star(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String
)
