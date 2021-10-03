package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class ListComingSoonMovies(
    @SerializedName("items")
    val list: List<MovieRequest>
)