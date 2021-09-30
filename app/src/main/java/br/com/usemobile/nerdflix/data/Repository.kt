package br.com.usemobile.nerdflix.data

import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest

interface Repository {

    suspend fun getComingSoonMovie(): Movie

}