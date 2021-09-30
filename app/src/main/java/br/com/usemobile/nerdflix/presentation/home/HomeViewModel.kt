package br.com.usemobile.nerdflix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.usemobile.nerdflix.data.RepositoryImpl
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val repository = RepositoryImpl.instance

    private val _comingSoon: MutableLiveData<Movie> = MutableLiveData()
    val comingSoon: LiveData<Movie> = _comingSoon

    fun getComingSoon() {
        CoroutineScope(Dispatchers.IO).launch {
            val movie = repository.getComingSoonMovie()
            _comingSoon.postValue(movie)
        }
    }

}