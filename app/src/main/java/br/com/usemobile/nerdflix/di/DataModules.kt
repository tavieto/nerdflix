package br.com.usemobile.nerdflix.di

import br.com.usemobile.nerdflix.data.LocalRepositoryImpl
import br.com.usemobile.nerdflix.domain.LocalRepository
import org.koin.dsl.module

val dataModules = module {
    single<LocalRepository> {
        LocalRepositoryImpl(get())
    }

}