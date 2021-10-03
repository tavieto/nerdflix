package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

class SetAllForYouMoviesUseCase(
    private val localRepository: LocalRepository
) {
    suspend fun setAllForYouMovies(movies: List<Movie>) {
        localRepository.setAllForYouMovies(movies)
    }
}