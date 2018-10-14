package xyz.godi.popularmovies.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.OnConflictStrategy;

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