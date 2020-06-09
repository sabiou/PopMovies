package xyz.godi.popularmovies.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import xyz.godi.popularmovies.model.Movie;

@Dao
public interface MovieDAO {

    // get all movies
    @Query("SELECT * FROM Movie")
    LiveData<List<Movie>> getAll();

    // insert movie into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movie movie);

    @Query("SELECT * FROM Movie Where id = :id")
    Movie getMovieById(int id);

    @Delete
    void delete(Movie movie);
}