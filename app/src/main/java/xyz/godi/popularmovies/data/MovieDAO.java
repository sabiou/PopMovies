package xyz.godi.popularmovies.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import xyz.godi.popularmovies.model.FavoriteMovie;
import xyz.godi.popularmovies.model.Movie;

@Dao
public interface MovieDAO {

    // get all movies
    @Query("SELECT * FROM movie")
    List<Movie> getAll();

    // insert movie into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movie movie);

    @Query("SELECT id FROM movie Where id = :id")
    FavoriteMovie getMovieById(String id);

    @Delete
    void delete(Movie movie);
}
