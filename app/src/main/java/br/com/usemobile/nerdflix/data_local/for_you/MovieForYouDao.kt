package br.com.usemobile.nerdflix.data_local.for_you

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieForYouDao {

    @Insert
    fun insertAll(movieDramas: List<MovieForYouEntity>)

    @Query("SELECT * FROM movies_for_you")
    fun getAll(): List<MovieForYouEntity>

    @Query("DELETE FROM movies_for_you")
    fun deleteAll()

}

