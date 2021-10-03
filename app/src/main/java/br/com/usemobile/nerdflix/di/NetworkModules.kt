package br.com.usemobile.nerdflix.di

import br.com.usemobile.nerdflix.data.NetworkRepositoryImpl
import br.com.usemobile.nerdflix.domain.NetworkRepository
import br.com.usemobile.nerdflix.network.ApiService
import br.com.usemobile.nerdflix.network.NetworkDataSource
import br.com.usemobile.nerdflix.network.NetworkDataSourceImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModules = module {

    single<ApiService> {
        Retrofit.Builder()
            .baseUrl("https://imdb-api.com/pt-br/API/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    single {
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(get())
    }

    single<NetworkDataSource> {
        NetworkDataSourceImpl(get())
    }
}