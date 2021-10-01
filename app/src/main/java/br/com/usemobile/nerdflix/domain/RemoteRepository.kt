package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.data_local.action.MovieActionEntity
import br.com.usemobile.nerdflix.data_local.drama.MovieDramaEntity
import br.com.usemobile.nerdflix.network.model.ListMovie
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest

interface RemoteRepository {

    suspend fun getComingSoonMovie(): ListMovie

}