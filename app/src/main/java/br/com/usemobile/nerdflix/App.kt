package br.com.usemobile.nerdflix

import android.app.Application
import br.com.usemobile.nerdflix.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(useCaseModules, presentationModules, networkModules, dataModules, dataLocalModules)
        }
    }
}