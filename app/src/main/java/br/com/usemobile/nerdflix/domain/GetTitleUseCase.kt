package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.commons.toMovie
import br.com.usemobile.nerdflix.commons.toMovieWithActors
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieId

class GetTitleUseCase(
    private val networkRepository: NetworkRepository
) {

    suspend fun getTitle(movieId: MovieId): Movie {
        return networkRepository.getTitle(movieId).toMovieWithActors()
    }

}