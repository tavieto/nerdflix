package br.com.usemobile.nerdflix.data_local.for_you

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usemobile.nerdflix.network.model.Genre
import br.com.usemobile.nerdflix.network.model.Star

@Entity(tableName = "movies_for_you")
data class MovieForYouEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "id_movie") val idMovie: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "path_image") val pathImage: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "star_list_string") val starListString: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "star_list") val starList: String,
    @ColumnInfo(name = "genre_list") val genreList: String
)