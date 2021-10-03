package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

class GetAllForYouMovieUseCase(
    private val localRepository: LocalRepository
) {

    suspend fun getAllForYouMovie(): List<Movie> {
        return localRepository.getAllForYouMovies()
    }

}