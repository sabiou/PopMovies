package xyz.godi.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(
        @SerializedName("key")
        var videoKey: String,
        @SerializedName("name")
        var name: String
) : Parcelable