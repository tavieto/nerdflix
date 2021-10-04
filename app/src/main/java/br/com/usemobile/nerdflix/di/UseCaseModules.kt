package br.com.usemobile.nerdflix.di

import br.com.usemobile.nerdflix.domain.*
import org.koin.dsl.module

val useCaseModules = module {
    single { GetComingSoonMoviesUseCase(get()) }
    single { GetAllActionMovieUseCase(get()) }
    single { GetAllDramaMovieUseCase(get()) }
    single { GetAllForYouMovieUseCase(get()) }
    single { SetAllActionMoviesUseCase(get()) }
    single { SetAllDramaMoviesUseCase(get()) }
    single { SetAllForYouMoviesUseCase(get()) }
    single { DeleteAllLocalDataUseCase(get()) }
    single { GetTop250MoviesUseCase(get()) }
    single { GetTitleUseCase(get()) }
    single { VerifyIfExistLocalDataUseCase(get()) }
}