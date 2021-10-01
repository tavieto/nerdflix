package br.com.usemobile.nerdflix.di

import br.com.usemobile.nerdflix.presentation.home.HomeViewModel
import br.com.usemobile.nerdflix.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { SplashViewModel(get(), get(), get()) }
}