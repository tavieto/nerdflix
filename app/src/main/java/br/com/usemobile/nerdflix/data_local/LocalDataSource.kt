package br.com.usemobile.nerdflix.data_local

import br.com.usemobile.nerdflix.network.model.Movie

interface LocalDataSource {

    suspend fun getAllDramaMovies(): List<Movie>

    suspend fun setAllDramaMovies(movies: List<Movie>)

    suspend fun getAllActionMovies(): List<Movie>

    suspend fun setAllActionMovies(movies: List<Movie>)

    suspend fun getAllForYouMovies(): List<Movie>

    suspend fun setAllForYouMovies(movies: List<Movie>)

    suspend fun deleteAll()

}