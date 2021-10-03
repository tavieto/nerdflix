package br.com.usemobile.nerdflix.network.model

import com.google.gson.annotations.SerializedName

data class ListTop250Movies(
    @SerializedName("items")
    val list: List<MovieId>
)