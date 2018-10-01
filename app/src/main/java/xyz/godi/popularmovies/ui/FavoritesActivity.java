package xyz.godi.popularmovies.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.model.Movie;
import xyz.godi.popularmovies.adapters.MovieAdapter;
import xyz.godi.popularmovies.viewModel.MovieViewModel;

public class FavoritesActivity extends AppCompatActivity {

    // LOG TAG
    private static final String LOG_TAG = FavoritesActivity.class.getSimpleName();

    // MovieViewModel instance
    private MovieViewModel viewModel;

    // Bind views using ButterKnife
    @BindView(R.id.movierecycler)
    RecyclerView movie_recycler;
    @BindView(R.id.empty)
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