package xyz.godi.popularmovies.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Generic class that represent different type of response from the api
 * @param <R>
 */
public class ApiResponse<R> {
    @SerializedName("results")
    public List<R> results;
}