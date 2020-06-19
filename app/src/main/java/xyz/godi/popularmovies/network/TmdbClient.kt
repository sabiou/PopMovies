package xyz.godi.popularmovies.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import xyz.godi.popularmovies.model.MovieResponse
import javax.inject.Inject

/**
 * Created by Farouk on 12/06/20.
 */
class TmdbClient @Inject constructor(
        private val tmdbService: TmdbService
) {
    fun fecthMoviesList(
            page: Int,
            onResult: (response: ApiResponse<MovieResponse>) -> Unit
    ) {
        tmdbService.fetchPopularMoviesList(
                limit = pagingSize,
                offset = page * pagingSize
        ).request(onResult)
    }

    companion object {
        private const val pagingSize = 20
    }
}