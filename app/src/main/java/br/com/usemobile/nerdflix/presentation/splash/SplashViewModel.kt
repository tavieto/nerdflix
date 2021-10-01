package br.com.usemobile.nerdflix.presentation.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.usemobile.nerdflix.commons.setActionFilter
import br.com.usemobile.nerdflix.commons.setDramaFilter
import br.com.usemobile.nerdflix.domain.GetAllMoviesUseCase
import br.com.usemobile.nerdflix.domain.SetAllDramaMoviesUseCase
import br.com.usemobile.nerdflix.network.model.Movie

class SplashViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val setAllDramaMovieUseCase: SetAllDramaMoviesUseCase,
    private val setAllActionMovieUseCase: SetAllDramaMoviesUseCase
): ViewModel() {

    fun getAllMovies() {
        Log.i("SplashViewModel", "QUALQUER COISA")
        val allMovies = getAllMoviesUseCase.getAllMovies()

        Log.i("SplashViewModel", "${getAllMoviesUseCase.getAllMovies()}")

        setDramaMovies(allMovies)
        setActionMovies(allMovies)
    }

    private fun setDramaMovies(movies: List<Movie>) {
        setAllDramaMovieUseCase.setAllDramaMovies(movies.setDramaFilter())
    }

    private fun setActionMovies(movies: List<Movie>) {
        setAllActionMovieUseCase.setAllDramaMovies(movies.setActionFilter())
    }

}