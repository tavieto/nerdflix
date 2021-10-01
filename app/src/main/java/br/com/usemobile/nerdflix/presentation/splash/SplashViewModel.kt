package br.com.usemobile.nerdflix.presentation.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.usemobile.nerdflix.commons.setActionFilter
import br.com.usemobile.nerdflix.commons.setDramaFilter
import br.com.usemobile.nerdflix.domain.GetAllMoviesUseCase
import br.com.usemobile.nerdflix.domain.SetAllDramaMoviesUseCase
import br.com.usemobile.nerdflix.network.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val setAllDramaMovieUseCase: SetAllDramaMoviesUseCase,
    private val setAllActionMovieUseCase: SetAllDramaMoviesUseCase
): ViewModel() {

    init {
        getAllMovies()
    }

    val success: MutableLiveData<Boolean> = MutableLiveData()

    private fun getAllMovies() {
        try {
        CoroutineScope(Dispatchers.IO).launch {

                val allMovies = getAllMoviesUseCase.getAllMovies()

                Log.i("SplashViewModel", "$allMovies")

                setDramaMovies(allMovies)
                setActionMovies(allMovies)

                CoroutineScope(Dispatchers.Main).launch {
                    success.value = true
                }
            }
        } catch (e: Throwable) {
            CoroutineScope(Dispatchers.Main).launch {
                success.value = false
            }
        }
    }

    private fun setDramaMovies(movies: List<Movie>) {
        setAllDramaMovieUseCase.setAllDramaMovies(movies.setDramaFilter())
    }

    private fun setActionMovies(movies: List<Movie>) {
        setAllActionMovieUseCase.setAllDramaMovies(movies.setActionFilter())
    }

}