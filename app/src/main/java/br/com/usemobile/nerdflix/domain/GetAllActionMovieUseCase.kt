package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.Movie

class GetAllActionMovieUseCase(
    private val localRepository: LocalRepository
) {

    fun getAllActionMovie(): List<Movie> {
        return localRepository.getAllActionMovies()
    }

}