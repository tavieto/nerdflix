package br.com.usemobile.nerdflix.data_local

import br.com.usemobile.nerdflix.commons.*
import br.com.usemobile.nerdflix.network.model.Movie

class LocalDataSourceImpl(
    private val roomDatabase: MoviesDatabase
): LocalDataSource {

    override suspend fun getAllDramaMovies(): List<Movie> {
        return roomDatabase.movieDramaDao().getAll().map { it.setStringify() }
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

    override suspend fun getAllForYouMovies(): List<Movie> {
        return roomDatabase.movieForYouDao().getAll().map { it.toMovie() }
    }

    override suspend fun setAllForYouMovies(movies: List<Movie>) {
        roomDatabase.movieForYouDao().insertAll(movies.map { it.toMovieForYouEntity() })
    }

    override suspend fun deleteAll() {
        roomDatabase.movieDramaDao().deleteAll()
        roomDatabase.movieActionDao().deleteAll()
        roomDatabase.movieForYouDao().deleteAll()
    }
}