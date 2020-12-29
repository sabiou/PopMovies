package xyz.godi.popularmovies.model

import com.google.gson.annotations.SerializedName

data class Review (
        @SerializedName("author")
        var author: String,
        @SerializedName("content")
        var content: String
)