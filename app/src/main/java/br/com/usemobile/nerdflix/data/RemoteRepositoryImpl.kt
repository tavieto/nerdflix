package br.com.usemobile.nerdflix.data

import br.com.usemobile.nerdflix.domain.RemoteRepository
import br.com.usemobile.nerdflix.network.NetworkDataSource
import br.com.usemobile.nerdflix.network.model.ListMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemoteRepositoryImpl(
    private val networkDataSourceImpl: NetworkDataSource
): RemoteRepository {

    override fun getComingSoonMovie(): ListMovie {
        var response = ListMovie(emptyList())
        CoroutineScope(Dispatchers.IO).launch {
            response = networkDataSourceImpl.getAllMovies()
        }
        return response
    }
}