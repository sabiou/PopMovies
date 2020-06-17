package xyz.godi.popularmovies.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import com.skydoves.whatif.whatIfNotNullOrEmpty
import xyz.godi.popularmovies.adapters.MovieAdapter
import xyz.godi.popularmovies.model.Movie
import xyz.godi.popularmovies.ui.home.HomeViewModel

/**
 * Created by Farouk on 12/06/20.
 */
@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("paginationMovieList")
fun paginationMovieList(view: RecyclerView, viewModel: HomeViewModel) {
    RecyclerViewPaginator(
            recyclerView = view,
            isLoading = { viewModel.isLoading().get() },
            loadMore = { viewModel.fetchMovieList(it) },
            onLast = { false }
    ).run {
        threshold = 8
    }
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, movieList: List<Movie>?) {
    movieList.whatIfNotNullOrEmpty {
        (view.adapter as? MovieAdapter)?.addMovieList(it)
    }
}