package xyz.godi.popularmovies.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.godi.popularmovies.model.MovieResponse

/**
 * Created by Farouk on 12/06/20.
 */
interface TmdbService {

    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    fun fetchPopularMoviesList(
            @Query("limit") limit: Int = 20,
            @Query("offset") offset: Int = 0
    ): Call<MovieResponse>
}