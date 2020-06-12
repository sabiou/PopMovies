package xyz.godi.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Review (
        @SerializedName("author")
        var author: String,
        @SerializedName("content")
        var content: String
) : Parcelable