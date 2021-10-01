package br.com.usemobile.nerdflix.di

import br.com.usemobile.nerdflix.data.RemoteRepositoryImpl
import br.com.usemobile.nerdflix.domain.RemoteRepository
import br.com.usemobile.nerdflix.network.NetworkDataSource
import br.com.usemobile.nerdflix.network.NetworkDataSourceImpl
import org.koin.dsl.module

val networkModules = module {
    single<RemoteRepository> {
        RemoteRepositoryImpl(get())
    }

    single<NetworkDataSource> {
        NetworkDataSourceImpl()
    }
}