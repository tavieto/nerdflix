package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

class SetAllDramaMoviesUseCase(
    private val localRepository: LocalRepository
) {
    suspend fun setAllDramaMovies(movies: List<Movie>) {
        localRepository.setAllDramaMovies(movies)
    }
}