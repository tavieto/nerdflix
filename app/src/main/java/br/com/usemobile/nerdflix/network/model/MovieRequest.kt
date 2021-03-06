package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class MovieRequest(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("image")
    val pathImage: String,

    @SerializedName("plot")
    val description: String = "",

    @SerializedName("starList")
    val starList: List<Star> = emptyList(),

    @SerializedName("genreList")
    val genreList: List<Genre>,

    val genre: Genre,

    @SerializedName("actorList")
    val actorList: List<ActorRequest>
)
