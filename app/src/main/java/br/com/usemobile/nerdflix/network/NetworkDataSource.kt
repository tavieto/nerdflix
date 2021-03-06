package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.ListComingSoonMovies
import br.com.usemobile.nerdflix.network.model.ListTop250Movies
import br.com.usemobile.nerdflix.network.model.MovieId
import br.com.usemobile.nerdflix.network.model.MovieRequest

interface NetworkDataSource {

    suspend fun getListComingSoonMovies(): ListComingSoonMovies

    suspend fun getListTop250Movies(): ListTop250Movies

    suspend fun getTitle(movieId: MovieId): MovieRequest
}