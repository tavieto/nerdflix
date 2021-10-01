package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.ListMovie

interface NetworkDataSource {

    suspend fun getAllMovies(): ListMovie
}