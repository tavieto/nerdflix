package br.com.usemobile.nerdflix.data

import br.com.usemobile.nerdflix.data_local.LocalDataSource
import br.com.usemobile.nerdflix.domain.LocalRepository
import br.com.usemobile.nerdflix.network.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource
): LocalRepository {

    override fun getAllDramaMovies(): List<Movie> {
        var list = emptyList<Movie>()

        CoroutineScope(Dispatchers.IO).launch {
            list = localDataSource.getAllDramaMovies()
        }
        return list
    }

    override fun setAllDramaMovies(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setAllActionMovies(movies)
        }
    }

    override fun getAllActionMovies(): List<Movie> {
        var list = emptyList<Movie>()

        CoroutineScope(Dispatchers.IO).launch {
            list = localDataSource.getAllActionMovies()
        }
        return list
    }

    override fun setAllActionMovies(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setAllDramaMovies(movies)
        }
    }
}