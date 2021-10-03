package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

class SetAllActionMoviesUseCase(
    private val localRepository: LocalRepository
) {
    suspend fun setAllActionMovies(movies: List<Movie>) {
        localRepository.setAllActionMovies(movies)
    }
}