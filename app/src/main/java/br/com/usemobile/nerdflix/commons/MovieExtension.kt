package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.data_local.action.MovieActionEntity
import br.com.usemobile.nerdflix.data_local.drama.MovieDramaEntity
import br.com.usemobile.nerdflix.network.model.Genre
import br.com.usemobile.nerdflix.network.model.Movie
import com.google.gson.Gson

fun Movie.toMovieDramaEntity(): MovieDramaEntity {
    val currentMovie = this
    val gson = Gson()

    return MovieDramaEntity(
        0,
        currentMovie.id,
        currentMovie.title,
        currentMovie.pathImage,
        currentMovie.description,
        currentMovie.starListString,
        Const.TYPE_DRAMA,
        gson.toJson(currentMovie.starList),
        gson.toJson(currentMovie.genreList)
    )
}

fun Movie.toMovieActionEntity(): MovieActionEntity {
    val currentMovie = this
    val gson = Gson()

    return MovieActionEntity(
        0,
        currentMovie.id,
        currentMovie.title,
        currentMovie.pathImage,
        currentMovie.description,
        currentMovie.starListString,
        Const.TYPE_ACTION,
        gson.toJson(currentMovie.starList),
        gson.toJson(currentMovie.genreList)
    )
}

