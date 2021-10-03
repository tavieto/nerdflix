package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.MovieId

class GetTop250MoviesUseCase(
    private val networkRepository: NetworkRepository
) {

    suspend fun getTop250Movies(): List<MovieId> {
        return networkRepository.getTop250Movies().list
    }

}