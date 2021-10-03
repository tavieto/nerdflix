package br.com.usemobile.nerdflix.domain

import br.com.usemobile.nerdflix.network.model.ListComingSoonMovies
import br.com.usemobile.nerdflix.network.model.ListTop250Movies
import br.com.usemobile.nerdflix.network.model.MovieId
import br.com.usemobile.nerdflix.network.model.MovieRequest

interface NetworkRepository {

    suspend fun getComingSoonMovie(): ListComingSoonMovies

    suspend fun getTop250Movies(): ListTop250Movies

    suspend fun getTitle(movieId: MovieId): MovieRequest

}