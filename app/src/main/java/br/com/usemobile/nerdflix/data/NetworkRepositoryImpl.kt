package br.com.usemobile.nerdflix.data

import br.com.usemobile.nerdflix.domain.NetworkRepository
import br.com.usemobile.nerdflix.network.NetworkDataSource
import br.com.usemobile.nerdflix.network.model.ListComingSoonMovies
import br.com.usemobile.nerdflix.network.model.ListTop250Movies
import br.com.usemobile.nerdflix.network.model.MovieId
import br.com.usemobile.nerdflix.network.model.MovieRequest

class NetworkRepositoryImpl(
    private val networkDataSourceImpl: NetworkDataSource
): NetworkRepository {

    override suspend fun getComingSoonMovie(): ListComingSoonMovies {
        return networkDataSourceImpl.getListComingSoonMovies()
    }

    override suspend fun getTop250Movies(): ListTop250Movies {
        return networkDataSourceImpl.getListTop250Movies()
    }

    override suspend fun getTitle(movieId: MovieId): MovieRequest {
        return networkDataSourceImpl.getTitle(movieId)
    }
}