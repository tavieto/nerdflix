package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.MovieRequest

interface NetworkDataSource {

    suspend fun getComingSoonMovie(): MovieRequest
}