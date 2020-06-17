package xyz.godi.popularmovies.ui.home

import androidx.databinding.ObservableBoolean
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.switchMap
import xyz.godi.popularmovies.base.LiveCoroutinesViewModel
import xyz.godi.popularmovies.model.Movie
import xyz.godi.popularmovies.repository.MainRepository

/**
 * Created by Farouk on 12/06/20.
 */
class HomeViewModel @ViewModelInject constructor(
        private val mainRepository: MainRepository,
        @Assisted private val stateHandle: SavedStateHandle
): LiveCoroutinesViewModel() {

    private var movieFetchingLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<List<Movie>>
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        // Timber.d("init MainViewModel")
        movieListLiveData = movieFetchingLiveData.switchMap {
            launchOnViewModelScope {
                this.mainRepository.fetchMoviesList(it) { this.toastLiveData.postValue(it) }
            }
        }
    }

    fun fetchMovieList(page: Int) {
        movieFetchingLiveData.value = page
    }

    fun isLoading(): ObservableBoolean = mainRepository.isLoading
}