package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.MovieRequest

class NetworkDataSourceImpl : NetworkDataSource {

    private val service = ApiService.service

    override suspend fun getComingSoonMovie(): MovieRequest {
        return service.getComingSoonMovie().list[0]
    }

    companion object {
        val instance: NetworkDataSource by lazy {
            NetworkDataSourceImpl()
        }
    }
}