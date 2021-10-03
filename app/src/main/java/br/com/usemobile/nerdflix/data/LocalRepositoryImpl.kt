package br.com.usemobile.nerdflix.data

import br.com.usemobile.nerdflix.data_local.LocalDataSource
import br.com.usemobile.nerdflix.domain.LocalRepository
import br.com.usemobile.nerdflix.network.model.Movie

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource
): LocalRepository {

    override suspend fun getAllDramaMovies(): List<Movie> {
        return localDataSource.getAllDramaMovies()
    }

    override suspend fun setAllDramaMovies(movies: List<Movie>) {
        localDataSource.setAllActionMovies(movies)
    }

    override suspend fun getAllActionMovies(): List<Movie> {
        return localDataSource.getAllActionMovies()
    }

    override suspend fun setAllActionMovies(movies: List<Movie>) {
        localDataSource.setAllDramaMovies(movies)
    }

    override suspend fun getAllForYouMovies(): List<Movie> {
        return localDataSource.getAllForYouMovies()
    }

    override suspend fun setAllForYouMovies(movies: List<Movie>) {
        localDataSource.setAllForYouMovies(movies)
    }

    override suspend fun deleteAll() {
        localDataSource.deleteAll()
    }


}