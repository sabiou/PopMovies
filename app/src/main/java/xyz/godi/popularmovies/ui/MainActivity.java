package xyz.godi.popularmovies.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.api.ApiResponse;
import xyz.godi.popularmovies.api.RetrofitClient;
import xyz.godi.popularmovies.api.Service;
import xyz.godi.popularmovies.viewModel.MovieViewModel;
import xyz.godi.popularmovies.model.Movie;
import xyz.godi.popularmovies.ui.adapters.MovieAdapter;
import xyz.godi.popularmovies.utils.Config;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Shared Preferences to save sort settings
    SharedPreferences mSharedPref;

    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    // Bind views using ButterKnife
    @BindView(R.id.mainLayout) FrameLayout homeLayout;
    @BindView(R.id.movie_rv)
    RecyclerView movie_recycler;
    @BindView(R.id.loading_spinner)
    ProgressBar loading_spinner;
    @BindView(R.id.empty_view)
    TextView emptyView_tv;
    @BindView(R.id.no_internet_iv)
    ImageView no_internet_iv;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // get viewModel from ViewModelProviders class
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        // set layout manager
        movie_recycler.setLayoutManager(new GridLayoutManager(this, getSpanCount()));

        // Get reference to Connectivity manager to check for network stat
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // get the current network
        assert cm != null;
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        //
        mSharedPref = getSharedPreferences("sortSettings", MODE_PRIVATE);

        String sorting = mSharedPref.getString("sort", "popular");

        // if there a network, load movies
        if (networkInfo != null && networkInfo.isConnected()) {
            loadPopularMovies();
        } else {
            loading_spinner.setVisibility(View.INVISIBLE);
            no_internet_iv.setVisibility(View.VISIBLE);
            emptyView_tv.setText(R.string.no_internet_connection);
        }

        // refresh content onSwipeToRefresh
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // call to refreshContent
                refreshContent();
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

    // Method to load movies
    private void loadPopularMovies() {
        Service apiService = RetrofitClient.getClient().create(Service.class);

        Call<ApiResponse<Movie>> call = apiService.getPopularMovies(Config.API_KEY);

        call.enqueue(new Callback<ApiResponse<Movie>>() {
            @Override
            public void onResponse(Call<ApiResponse<Movie>> call, Response<ApiResponse<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = fetchResults(response);
                    movie_recycler.setAdapter(new MovieAdapter(getApplicationContext(), movies));
                    // hide the loading indicator
                    loading_spinner.setVisibility(View.INVISIBLE);
                } else {
                    Snackbar.make(homeLayout,R.string.network_error,Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Movie>> call, Throwable t) {
                Log.e(LOG_TAG, t.getMessage());
            }
        });
    }

    // Method to load top rated movies
    private void loadTopRatedMovies() {
        Service apiService = RetrofitClient.getClient().create(Service.class);

        Call<ApiResponse<Movie>> call = apiService.getTopRatedMovies(Config.API_KEY);

        call.enqueue(new Callback<ApiResponse<Movie>>() {
            @Override
            public void onResponse(Call<ApiResponse<Movie>> call, Response<ApiResponse<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = fetchResults(response);
                    movie_recycler.setAdapter(new MovieAdapter(getApplicationContext(), movies));
                    // hide the loading indicator
                    loading_spinner.setVisibility(View.INVISIBLE);
                } else {
                    Snackbar.make(homeLayout,R.string.network_error,Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Movie>> call, Throwable t) {
                Log.e(LOG_TAG, t.getMessage());
            }
        });
    }

    private void loadFavorites() {
        movieViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                // update from cahed data
                movie_recycler.setAdapter(new MovieAdapter(getApplicationContext(),movies));
            }
        });
    }

    private List<Movie> fetchResults(Response<ApiResponse<Movie>> response) {
        ApiResponse<Movie> movieResponse = response.body();
        return movieResponse.results;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.about) {
            // Start the AboutActivity
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;

        } else if (itemId == R.id.sort) {
            showSortDialog();
        }
        return super.onOptionsItemSelected(item);

    }

    private void showSortDialog() {
        // options to display in dialog
        String[] sortOptions = {"Popular", "Top rated", "Favorites"};

        //  Create alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort by")
                .setIcon(R.drawable.ic_sort_15dp)
                .setItems(sortOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // load movies accordingly to the selected option
                        if (which == 0) {
                            loadPopularMovies();
                        } else if (which == 1) {
                            loadTopRatedMovies();
                        } else if (which == 2) {
                            loadFavorites();
                        }
                        loadTopRatedMovies();
                    }
                }).show(); // show the alert dialog
    }

    // Method to call on refresh
    private void refreshContent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadPopularMovies();
                swipeRefresh.setRefreshing(false);
            }
        }, 3000);
        // stop the refreshing
    }
}