package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.commons.toMovie
import br.com.usemobile.nerdflix.network.model.Movie

class GetComingSoonMoviesUseCase(
    private val networkRepository: NetworkRepository
) {

    suspend fun getComingSoonMovies(): List<Movie> {
        return networkRepository.getComingSoonMovie().list.map { it.toMovie() }
    }

}