package xyz.godi.popularmovies.base

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
/**
 * Created by Farouk on 12/06/20.
 */

abstract class LiveCoroutinesViewModel : ViewModel() {
    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(block())
        }
    }
}