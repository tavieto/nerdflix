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

    override suspend fun getComingSoonMovie(): ListMovie {
        return networkDataSourceImpl.getAllMovies()
    }
}