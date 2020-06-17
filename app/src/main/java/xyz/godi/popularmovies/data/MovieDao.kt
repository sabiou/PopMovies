package xyz.godi.popularmovies.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xyz.godi.popularmovies.model.Movie

/**
 * Created by Farouk on 12/06/20.
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movieList: List<Movie>)

    @Query("SELECT * FROM Movie WHERE page = :page_")
    fun getMovieList(page_: Int): List<Movie>
}