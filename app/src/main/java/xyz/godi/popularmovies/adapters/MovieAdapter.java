package xyz.godi.popularmovies.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.model.Movie;
import xyz.godi.popularmovies.ui.DetailsActivity;
import xyz.godi.popularmovies.utils.ConstantsUtils;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context mContext, List<Movie> movies) {
        this.context = mContext;
        this.movies = movies;
    }

    class MovieViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener {
        // Bind views using ButterKnife
        @BindView(R.id.poster_iv)
        ImageView poster_iv;

        MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Start DetailsActivity
            Intent intent = new Intent(v.getContext(), DetailsActivity.class);
            Movie currentMovie = movies.get(getAdapterPosition());
            intent.putExtra(Movie.TAG, currentMovie);
            intent.putExtra(DetailsActivity.TAG,currentMovie);
            v.getContext().startActivity(intent);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // get the Movie object located at the apppropriate position
        final Movie movie = movies.get(position);

        // set the movie poster image
        String poster_url = ConstantsUtils.MOVIE_POSTER_BASE_URL +
                ConstantsUtils.MOVIE_POSTER_SIZE_W500 + movie.getPoster_path();
        Picasso.get()
                .load(poster_url)
                .placeholder(new ColorDrawable(Color.GRAY))
                .error(new ColorDrawable(Color.BLACK))
                .into(holder.poster_iv);
    }

    public void setMovies(List<Movie> movieList) {
        movies = movieList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}