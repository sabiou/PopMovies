package xyz.godi.popularmovies.repository

import androidx.databinding.ObservableBoolean

/**
 * Created by Farouk on 12/06/20.
 */
// Repository is an interface for configuring base repository classes.

interface Repository {
    // this override property is for saving network loading status.
    var isLoading: ObservableBoolean
}