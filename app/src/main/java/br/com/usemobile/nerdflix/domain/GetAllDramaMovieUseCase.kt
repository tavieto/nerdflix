package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

class GetAllDramaMovieUseCase(
    private val localRepository: LocalRepository
) {

    suspend fun getAllDramaMovie(): List<Movie> {
        return localRepository.getAllDramaMovies()
    }

}