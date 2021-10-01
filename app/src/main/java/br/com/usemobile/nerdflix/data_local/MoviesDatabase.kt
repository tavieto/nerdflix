package br.com.usemobile.nerdflix.data_local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.usemobile.nerdflix.data_local.action.MovieActionDao
import br.com.usemobile.nerdflix.data_local.action.MovieActionEntity
import br.com.usemobile.nerdflix.data_local.drama.MovieDramaDao
import br.com.usemobile.nerdflix.data_local.drama.MovieDramaEntity
import br.com.usemobile.nerdflix.data_local.for_you.MovieForYouDao
import br.com.usemobile.nerdflix.data_local.for_you.MovieForYouEntity

@Database(
    entities = [MovieActionEntity::class, MovieDramaEntity::class, MovieForYouEntity::class],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDramaDao(): MovieDramaDao
    abstract fun movieActionDao(): MovieActionDao
    abstract fun movieForYouDao(): MovieForYouDao
}