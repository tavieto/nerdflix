package br.com.usemobile.nerdflix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.usemobile.nerdflix.domain.GetAllActionMovieUseCase
import br.com.usemobile.nerdflix.domain.GetAllDramaMovieUseCase
import br.com.usemobile.nerdflix.network.model.Movie


class HomeViewModel(
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
//            _comingSoon.postValue(listMovie.list[(0..20).random()].toModel())
//            _forYou.postValue(forYouList.map { it.toModel() })
        _drama.value = getAllDramaMovieUseCase.getAllDramaMovie()
        _action.value = getAllActionMovieUseCase.getAllActionMovie()

    }

}