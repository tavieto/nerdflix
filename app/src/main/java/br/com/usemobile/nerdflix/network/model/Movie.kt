package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: String,
    val title: String,
    val pathImage: String,
    val description: String,
    val starListString: String
)
