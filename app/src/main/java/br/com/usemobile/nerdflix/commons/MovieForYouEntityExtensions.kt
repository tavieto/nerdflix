package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.data_local.drama.MovieDramaEntity
import br.com.usemobile.nerdflix.data_local.for_you.MovieForYouEntity
import br.com.usemobile.nerdflix.network.model.Genre
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.Star
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun MovieForYouEntity.toMovie(): Movie {
    val currentMovieDB = this
    val gson = Gson()

    val listStarTypeToken = object : TypeToken<List<Star>>() {}.type
    val listGenreTypeToken = object : TypeToken<List<Genre>>() {}.type

    return Movie(
        currentMovieDB.idMovie,
        currentMovieDB.title,
        currentMovieDB.pathImage,
        currentMovieDB.description,
        currentMovieDB.starListString,
        gson.fromJson(currentMovieDB.starList, listStarTypeToken) as List<Star>,
        gson.fromJson(currentMovieDB.genreList, listGenreTypeToken) as List<Genre>,
        currentMovieDB.genre
    )
}