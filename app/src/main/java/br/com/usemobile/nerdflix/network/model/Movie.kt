package br.com.usemobile.nerdflix.network.model

data class Movie(
    val id: String,
    val title: String,
    val pathImage: String,
    val description: String,
    val starListString: String,
    val starList: List<Star>,
    val genreList: List<Genre>,
    val genre: String,
    val actorList: List<ActorRequest> = emptyList()
)
