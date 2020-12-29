package xyz.godi.popularmovies.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity

data class Movie(
        var page: Int = 0,
        @PrimaryKey
        @SerializedName("id")
        var id: Int,
        @SerializedName("poster_path")
        val poster_path: String?,
        @SerializedName("backdrop_path")
        val backdrop_path: String?,
        @SerializedName("original_title")
        var original_title: String,
        @SerializedName("release_date")
        var release_date: String,
        @SerializedName("vote_count")
        var vote_count: Int,
        @SerializedName("vote_average")
        var vote_average: Double,
        @SerializedName("overview")
        var overview: String
)