package xyz.godi.popularmovies.model

import com.google.gson.annotations.SerializedName

data class Video(
        @SerializedName("key")
        var videoKey: String,
        @SerializedName("name")
        var name: String
)