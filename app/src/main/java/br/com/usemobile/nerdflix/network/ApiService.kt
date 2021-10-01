package br.com.usemobile.nerdflix.network

import br.com.usemobile.nerdflix.network.model.ListMovie
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {



    companion object {

        val service: ApiService by lazy {
            this.newInstance()
        }

        private const val API_KEY = "k_81yrhlr7"

        private fun newInstance(): ApiService = Retrofit.Builder()
            .baseUrl("https://imdb-api.com/pt-br/API/")
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @GET("ComingSoon/$API_KEY")
    suspend fun getComingSoonMovies() : ListMovie


}