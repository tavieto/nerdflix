package br.com.usemobile.nerdflix.presentation.more

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

class MoreViewModel(
    private val getAllForYouMovieUseCase: GetAllForYouMovieUseCase,
    private val getAllDramaMovieUseCase: GetAllDramaMovieUseCase,
    private val getAllActionMovieUseCase: GetAllActionMovieUseCase
): ViewModel() {

    private val _forYouMovieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val forYouMovieList: LiveData<List<Movie>> = _forYouMovieList

    private val _dramaMovieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val dramaMovieList: LiveData<List<Movie>> = _dramaMovieList

    private val _actionMovieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val actionMovieList: LiveData<List<Movie>> = _actionMovieList

    fun getAllForYouMovie() {
        var forYou: List<Movie>
        CoroutineScope(Dispatchers.IO).launch {
            forYou = getAllForYouMovieUseCase.getAllForYouMovie()
            CoroutineScope(Dispatchers.Main).launch {
                _forYouMovieList.value = forYou
            }
        }
    }

    fun getAllActionMovie() {
        var actionList: List<Movie>
        CoroutineScope(Dispatchers.IO).launch {
            actionList = getAllActionMovieUseCase.getAllActionMovie()
            CoroutineScope(Dispatchers.Main).launch {
                _actionMovieList.value = actionList
            }
        }
    }

    fun getAllDramaMovie() {
        var dramaList: List<Movie>
        CoroutineScope(Dispatchers.IO).launch {
            dramaList = getAllDramaMovieUseCase.getAllDramaMovie()
            CoroutineScope(Dispatchers.Main).launch {
                _dramaMovieList.value = dramaList
            }
        }
    }

}