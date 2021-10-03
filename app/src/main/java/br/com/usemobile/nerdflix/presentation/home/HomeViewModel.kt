package br.com.usemobile.nerdflix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.usemobile.nerdflix.domain.GetAllActionMovieUseCase
import br.com.usemobile.nerdflix.domain.GetAllDramaMovieUseCase
import br.com.usemobile.nerdflix.domain.GetAllForYouMovieUseCase
import br.com.usemobile.nerdflix.network.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel(
    private val getAllForYouMovieUseCase: GetAllForYouMovieUseCase,
    private val getAllDramaMovieUseCase: GetAllDramaMovieUseCase,
    private val getAllActionMovieUseCase: GetAllActionMovieUseCase
) : ViewModel() {

    private val _comingSoon: MutableLiveData<Movie> = MutableLiveData()
    val comingSoon: LiveData<Movie> = _comingSoon

    private val _forYou: MutableLiveData<List<Movie>> = MutableLiveData()
    val forYou: LiveData<List<Movie>> = _forYou

    private val _drama: MutableLiveData<List<Movie>> = MutableLiveData()
    val drama: LiveData<List<Movie>> = _drama

    private val _action: MutableLiveData<List<Movie>> = MutableLiveData()
    val action: LiveData<List<Movie>> = _action

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            val allMovies = getAllForYouMovieUseCase.getAllForYouMovie()
            val comingSoon = allMovies[(0..(allMovies.size-1)).random()]
            val forYouMovies = allMovies
            val dramaMovies = getAllDramaMovieUseCase.getAllDramaMovie().shuffled()
            val actionMovies = getAllActionMovieUseCase.getAllActionMovie().shuffled()

            CoroutineScope(Dispatchers.Main).launch {
                _comingSoon.value = comingSoon
                _forYou.value = forYouMovies.take(4)
                _drama.value = actionMovies.take(4)
                _action.value = dramaMovies.take(4)
            }
        }

    }

}