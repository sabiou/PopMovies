package xyz.godi.popularmovies.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import xyz.godi.popularmovies.model.Movie;

public class MovieRepository {

    // members variables
    private MovieDAO dao;
    private LiveData<List<Movie>> movies;

    public MovieRepository(Application application) {
        MovieDataBase dataBase = MovieDataBase.getDatabase(application);
        dao = dataBase.movieDAO();
        movies = dao.getAll();
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void insert(Movie movie) {
        new InsertAsyncTask(dao).execute(movie);
    }

    private static class InsertAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO asyncDao;

        InsertAsyncTask(MovieDAO dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            asyncDao.insert(movies[0]);
            return null;
        }
    }
}
