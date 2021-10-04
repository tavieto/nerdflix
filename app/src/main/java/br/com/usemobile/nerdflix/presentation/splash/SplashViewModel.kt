package br.com.usemobile.nerdflix.presentation.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.usemobile.nerdflix.commons.getImage
import br.com.usemobile.nerdflix.commons.setActionFilter
import br.com.usemobile.nerdflix.commons.setDramaFilter
import br.com.usemobile.nerdflix.domain.*
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getComingSoonMoviesUseCase: GetComingSoonMoviesUseCase,
    private val getTop250MoviesUseCase: GetTop250MoviesUseCase,
    private val getTitleUseCase: GetTitleUseCase,
    private val setAllDramaMovieUseCase: SetAllDramaMoviesUseCase,
    private val setAllActionMovieUseCase: SetAllActionMoviesUseCase,
    private val setAllForYouMoviesUseCase: SetAllForYouMoviesUseCase,
    private val deleteAllLocalDataUseCase: DeleteAllLocalDataUseCase,
    private val verifyIfExistLocalDataUseCase: VerifyIfExistLocalDataUseCase
) : ViewModel() {

    init {
//        deleteAllData()
        verifyIfExistLocalData()
    }

    val success: MutableLiveData<Boolean> = MutableLiveData()

    val existLocalData: MutableLiveData<Boolean> = MutableLiveData()

    private fun getAllMovies() {
        try {
            Log.i("SPLASH", "CHEGUEI NO TRY")
            CoroutineScope(Dispatchers.IO).launch {

                delay(2000L)

                val top250Movies = getTop250Movies().take(20)

                // Iria implementar os filmes do Coming Soon no item de lançamento, mas deixei quieto.
                // val comingSoonMovies = getComingSoonMovies()

                val allMovies: MutableList<Movie> = mutableListOf()

                top250Movies.forEach { movieId ->
                    allMovies.add(getTitle(movieId))
                }

                val allMovieShuffled = allMovies.shuffled()

                setForYouMovies(allMovieShuffled)
                setDramaMovies(allMovies)
                setActionMovies(allMovies)

                CoroutineScope(Dispatchers.Main).launch {
                    success.value = true
                }
            }
        } catch (e: Throwable) {
            // No network connection
        }
    }

    private suspend fun getComingSoonMovies(): List<Movie> {
        return getComingSoonMoviesUseCase.getComingSoonMovies()
    }

    private suspend fun getTop250Movies(): List<MovieId> {
        return getTop250MoviesUseCase.getTop250Movies()
    }

    private suspend fun getTitle(movieId: MovieId): Movie {
        val title = getTitleUseCase.getTitle(movieId)
        title.starList.forEach {
            it.getImage(title.actorList)
        }
        return title
    }

    private fun setDramaMovies(movies: List<Movie>) {
        val filterDrama = movies.setDramaFilter()
        CoroutineScope(Dispatchers.IO).launch {
            setAllDramaMovieUseCase.setAllDramaMovies(filterDrama)
        }
    }

    private fun setActionMovies(movies: List<Movie>) {
        val filterAction = movies.setActionFilter()
        CoroutineScope(Dispatchers.IO).launch {
            setAllActionMovieUseCase.setAllActionMovies(filterAction)
        }
    }

    private fun setForYouMovies(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            setAllForYouMoviesUseCase.setAllForYouMovies(movies)
        }
    }

    private fun deleteAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            deleteAllLocalDataUseCase.deleteAll()
        }
    }

    private fun verifyIfExistLocalData() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = verifyIfExistLocalDataUseCase.verifyIfExistLocalData()
            CoroutineScope(Dispatchers.Main).launch {
                existLocalData.value = response
            }

            if (!response) {
                getAllMovies()
            }
        }
    }

}