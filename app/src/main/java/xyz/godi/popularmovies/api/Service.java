package xyz.godi.popularmovies.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import xyz.godi.popularmovies.model.Movie;
import xyz.godi.popularmovies.model.Review;
import xyz.godi.popularmovies.model.Video;

public interface Service {
    // get a list of popular movies
    @GET("movie/popular")
    Call<ApiResponse<Movie>> getPopularMovies(@Query("api_key") String api_key);

    // get a list of top rated movies
    @GET("movie/top_rated")
    Call<ApiResponse<Movie>> getTopRatedMovies(@Query("api_key") String api_key);

    // get a selected movie trailer
    @GET("movie/{id}/videos")
    Call<ApiResponse<Video>> getMovieTrailers(@Path("id") int id, @Query("api_key") String api_key);

    // get a selected movie review
    @GET("movie/{id}/reviews")
    Call<ApiResponse<Review>> getMovieReviews(@Path("id") int id, @Query("api_key") String api_key);
}