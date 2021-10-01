package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest
import br.com.usemobile.nerdflix.network.model.Star

fun List<Star>.toModel(): String {
    var stringStars = this[0].name
    var counter = 1

    while (counter < this.size) {
        stringStars += " - ${this[counter].name}"
        counter++
    }

    return stringStars
}

fun List<Movie>.setDramaFilter(): List<Movie> {
    val currentList = this
    val listDrama: MutableList<Movie> = mutableListOf()

    for (movie in currentList) {
        for (genre in movie.genreList) {
            if (genre.key == Const.TYPE_DRAMA) {
                listDrama.add(movie)
            }
        }
    }
    return listDrama
}

fun List<Movie>.setActionFilter(): List<Movie> {
    val currentList = this
    val listAction: MutableList<Movie> = mutableListOf()

    for (movie in currentList) {
        for (genre in movie.genreList) {
            if (genre.key == Const.TYPE_ACTION) {
                listAction.add(movie)
            }
        }
    }
    return listAction
}