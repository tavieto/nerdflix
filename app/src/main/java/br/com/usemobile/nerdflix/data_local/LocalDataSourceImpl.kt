package br.com.usemobile.nerdflix.data_local

import br.com.usemobile.nerdflix.commons.toMovie
import br.com.usemobile.nerdflix.commons.toMovieActionEntity
import br.com.usemobile.nerdflix.commons.toMovieDramaEntity
import br.com.usemobile.nerdflix.network.model.Movie

class LocalDataSourceImpl(
    private val roomDatabase: MoviesDatabase
): LocalDataSource {

    override suspend fun getAllDramaMovies(): List<Movie> {
        return roomDatabase.movieDramaDao().getAll().map { it.toMovie() }
    }

    override suspend fun setAllDramaMovies(movies: List<Movie>) {
        roomDatabase.movieDramaDao().insertAll(movies.map { it.toMovieDramaEntity() })
    }

    override suspend fun getAllActionMovies(): List<Movie> {
        return roomDatabase.movieActionDao().getAll().map { it.toMovie() }
    }

    override suspend fun setAllActionMovies(movies: List<Movie>) {
        roomDatabase.movieActionDao().insertAll(movies.map { it.toMovieActionEntity() })
    }
}