package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.ListComingSoonMovies
import br.com.usemobile.nerdflix.network.model.ListTop250Movies
import br.com.usemobile.nerdflix.network.model.MovieId
import br.com.usemobile.nerdflix.network.model.MovieRequest

class NetworkDataSourceImpl(
    private val service: ApiService
) : NetworkDataSource {

    override suspend fun getListComingSoonMovies(): ListComingSoonMovies {
        return service.getComingSoonMovies()
    }

    override suspend fun getListTop250Movies(): ListTop250Movies {
        return service.getTop250Movies()
    }

    override suspend fun getTitle(movieId: MovieId): MovieRequest {
        return service.getTitle(movieId.id)
    }

}