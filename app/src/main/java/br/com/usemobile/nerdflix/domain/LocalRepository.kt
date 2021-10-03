package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

interface LocalRepository {

    suspend fun getAllDramaMovies(): List<Movie>

    suspend fun setAllDramaMovies(movies: List<Movie>)

    suspend fun getAllActionMovies(): List<Movie>

    suspend fun setAllActionMovies(movies: List<Movie>)

    suspend fun getAllForYouMovies(): List<Movie>

    suspend fun setAllForYouMovies(movies: List<Movie>)

    suspend fun deleteAll()

}