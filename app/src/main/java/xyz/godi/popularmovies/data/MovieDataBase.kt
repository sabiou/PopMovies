package xyz.godi.popularmovies.data

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.godi.popularmovies.model.Movie

/**
 * Movie database class used to store favorite movie data
 */
@Database(entities = [Movie::class], version = 1, exportSchema = true)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}