package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

interface LocalRepository {

    fun getAllDramaMovies(): List<Movie>

    fun setAllDramaMovies(movies: List<Movie>)

    fun getAllActionMovies(): List<Movie>

    fun setAllActionMovies(movies: List<Movie>)

}