package xyz.godi.popularmovies.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import xyz.godi.popularmovies.data.MovieRepository;
import xyz.godi.popularmovies.model.Movie;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    private LiveData<List<Movie>> allMovies;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
        allMovies = movieRepository.getMovies();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return allMovies;
    }

    public void insert(Movie movie) {
        movieRepository.insert(movie);
    }
}
