package br.com.usemobile.nerdflix.di

import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.usemobile.nerdflix.data_local.LocalDataSource
import br.com.usemobile.nerdflix.data_local.LocalDataSourceImpl
import br.com.usemobile.nerdflix.data_local.MoviesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModules = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            MoviesDatabase::class.java, "movies"
        ).build()
    }

    single<LocalDataSource> {
        LocalDataSourceImpl(get())
    }

}