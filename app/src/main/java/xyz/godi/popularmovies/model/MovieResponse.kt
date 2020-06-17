package xyz.godi.popularmovies.model

/**
 * Created by Farouk on 12/06/20.
 */

import com.google.gson.annotations.SerializedName

data class MovieResponse(
        @SerializedName("count") val count: Int,
        @SerializedName("next") val next: String?,
        @SerializedName("previous") val previous: String?,
        @SerializedName("results") val results: List<Movie>
)