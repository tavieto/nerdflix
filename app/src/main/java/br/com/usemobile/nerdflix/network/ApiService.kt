package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.ListComingSoonMovies
import br.com.usemobile.nerdflix.network.model.ListTop250Movies
import br.com.usemobile.nerdflix.network.model.MovieRequest
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface ApiService {



    companion object {
//        private const val API_KEY = "k_81yrhlr7"
//        private const val API_KEY = "k_jatute1z"
//        private const val API_KEY = "k_pw9977ot"
//        private const val API_KEY = "k_8z6jx85d"
//        private const val API_KEY = "k_gamtsz4c"
        private const val API_KEY = "k_id1a0ztu"
    }

    @GET("ComingSoon/$API_KEY")
    suspend fun getComingSoonMovies() : ListComingSoonMovies

    @GET("Top250Movies/$API_KEY")
    suspend fun getTop250Movies(): ListTop250Movies

    @GET("Title/$API_KEY/{id}")
    suspend fun getTitle(@Path("id") id: String): MovieRequest

}