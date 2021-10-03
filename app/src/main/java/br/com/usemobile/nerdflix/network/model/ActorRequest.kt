package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class ActorRequest(
    @SerializedName("id")
    val id: String,

    @SerializedName("image")
    val pathImage: String,

    @SerializedName("name")
    val name: String
)
