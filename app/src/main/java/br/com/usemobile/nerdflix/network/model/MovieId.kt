package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class MovieId (
    @SerializedName("id")
    val id: String
)