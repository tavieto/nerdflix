package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.ListMovie

class NetworkDataSourceImpl : NetworkDataSource {

    private val service = ApiService.service

    override suspend fun getAllMovies(): ListMovie {
        return service.getComingSoonMovies()
    }

    companion object {
        val instance: NetworkDataSource by lazy {
            NetworkDataSourceImpl()
        }
    }
}