package br.com.usemobile.nerdflix.data_local.drama

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDramaDao {

    @Insert
    fun insertAll(movieDramas: List<MovieDramaEntity>)

    @Query("SELECT * FROM movies_drama")
    fun getAll(): List<MovieDramaEntity>

    @Query("DELETE FROM movies_drama")
    fun deleteAll()

}

