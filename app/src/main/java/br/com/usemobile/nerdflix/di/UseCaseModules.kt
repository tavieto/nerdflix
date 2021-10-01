package br.com.usemobile.nerdflix.di

import br.com.usemobile.nerdflix.domain.*
import org.koin.dsl.module

val useCaseModules = module {
    single { GetAllMoviesUseCase(get()) }
    single { GetAllActionMovieUseCase(get()) }
    single { GetAllDramaMovieUseCase(get()) }
    single { SetAllActionMoviesUseCase(get()) }
    single { SetAllDramaMoviesUseCase(get()) }
}