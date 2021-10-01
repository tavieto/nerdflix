package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.commons.toModel
import br.com.usemobile.nerdflix.network.model.Movie

class GetAllMoviesUseCase(
    private val remoteRepository: RemoteRepository
) {

    suspend fun getAllMovies(): List<Movie> {
        return remoteRepository.getComingSoonMovie().list.map { it.toModel() }
    }

}