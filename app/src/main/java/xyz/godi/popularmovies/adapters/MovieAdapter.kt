package xyz.godi.popularmovies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import xyz.godi.popularmovies.R
import xyz.godi.popularmovies.adapters.MovieAdapter.MovieViewHolder
import xyz.godi.popularmovies.databinding.MovieItemBinding
import xyz.godi.popularmovies.model.Movie

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val items: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
                DataBindingUtil.inflate<MovieItemBinding>(inflater, R.layout.movie_item, parent, false)
        return MovieViewHolder(binding)
    }

    fun addMovieList(movieList: List<Movie>) {
        items.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            movie = item
            executePendingBindings()
        }
    }

    override fun getItemCount() = items.size

    class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)
}