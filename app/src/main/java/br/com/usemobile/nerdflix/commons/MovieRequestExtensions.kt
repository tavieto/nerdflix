package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest

fun MovieRequest.toMovie(): Movie {
    val currentMovie = this
    return Movie(
        currentMovie.id,
        currentMovie.title,
        currentMovie.pathImage,
        currentMovie.description,
        currentMovie.starList.setStringify(),
        currentMovie.starList,
        currentMovie.genreList,
        ""
    )
}

fun MovieRequest.toMovieWithActors(): Movie {
    val currentMovie = this
    return Movie(
        currentMovie.id,
        currentMovie.title,
        currentMovie.pathImage,
        currentMovie.description,
        currentMovie.starList.setStringify(),
        currentMovie.starList,
        currentMovie.genreList,
        "",
        currentMovie.actorList
    )
}