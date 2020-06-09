package xyz.godi.popularmovies.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.adapters.MovieAdapter;
import xyz.godi.popularmovies.model.Movie;
import xyz.godi.popularmovies.viewModel.MovieViewModel;

public class FavoritesActivity extends AppCompatActivity {

    // LOG TAG
    private static final String LOG_TAG = FavoritesActivity.class.getSimpleName();

    // MovieViewModel instance
    private MovieViewModel viewModel;

    // Bind views using ButterKnife
    @BindView(R.id.movierecycler)
    RecyclerView movie_recycler;
    @BindView(R.id.empty_favorites)
    TextView emptyView_tv;
    @BindView(R.id.no_internet)
    ImageView no_internet_iv;
    @BindView(R.id.refresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        ButterKnife.bind(this);

        // get viewModel from ViewModelProviders class
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        // set layout manager
        movie_recycler.setLayoutManager(new GridLayoutManager(this, getSpanCount()));

        loadFavorites();

        // refresh content with swipe to refresh
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // call to refresh method
                refreshFavorites();
            }
        });
    }

    // check if the device is in landscape mode
    private int getSpanCount() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return 4;
        }
        return 3;
    }

    // method to load favorites Movies
    private void loadFavorites() {
        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                movie_recycler.setAdapter(new MovieAdapter(getApplicationContext(),movies));
            }
        });
    }

    private void refreshFavorites() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadFavorites();
                swipeRefresh.setRefreshing(false);
            }
        }, 3000);
        // stop the refreshing
    }
}