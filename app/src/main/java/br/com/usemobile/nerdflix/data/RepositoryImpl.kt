package br.com.usemobile.nerdflix.data

import br.com.usemobile.nerdflix.commons.toModel
import br.com.usemobile.nerdflix.network.NetworkDataSourceImpl
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest

class RepositoryImpl: Repository {

    private val networkDataSourceImpl = NetworkDataSourceImpl.instance

    override suspend fun getComingSoonMovie(): Movie {
        return networkDataSourceImpl.getComingSoonMovie().toModel()
    }

    companion object {
        val instance : Repository by lazy {
            RepositoryImpl()
        }
    }
}