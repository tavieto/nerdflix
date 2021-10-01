package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.network.model.Genre
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest

fun MovieRequest.toModel(): Movie {
    return Movie(
        id,
        title,
        pathImage,
        description,
        starList.toModel(),
        starList,
        genreList,
        ""
    )
}