package xyz.godi.popularmovies.repository

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import xyz.godi.popularmovies.data.MovieDao
import xyz.godi.popularmovies.model.Movie
import xyz.godi.popularmovies.network.TmdbClient
import javax.inject.Inject

/**
 * Created by Farouk on 12/06/20.
 */
class MainRepository @Inject constructor(
        private val tmdbClient: TmdbClient,
        private val movieDao: MovieDao) : Repository {

    override var isLoading: ObservableBoolean = ObservableBoolean(false)

    suspend fun fetchMoviesList(page: Int, error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Movie>>()
        var moviesList = movieDao.getMovieList(page)
        if (moviesList.isEmpty()) {
            isLoading.set(true)
            tmdbClient.fecthMoviesList(page = page) {
                isLoading.set(false)
                // handle the case when the API request gets a success response.
                it.onSuccess {
                    data.whatIfNotNull { response ->
                        moviesList = response.results
                        moviesList.forEach { movie -> movie.page = page }
                        liveData.postValue(moviesList)
                        movieDao.insertMovieList(moviesList)
                    }
                } // handle the case when the API request gets a error response.
                        // e.g. internal server error.
                        .onError {
                            error(message())
                        }
            }
        }
        liveData.apply { postValue(moviesList) }
    }

}