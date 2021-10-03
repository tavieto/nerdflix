package br.com.usemobile.nerdflix.data_local.action

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieActionDao {

    @Insert
    fun insertAll(movies: List<MovieActionEntity>)

    @Query("SELECT * FROM movies_action")
    fun getAll(): List<MovieActionEntity>

    @Query("DELETE FROM movies_action")
    fun deleteAll()

}