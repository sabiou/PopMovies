package xyz.godi.popularmovies.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.api.ApiResponse;
import xyz.godi.popularmovies.api.RetrofitClient;
import xyz.godi.popularmovies.api.Service;
import xyz.godi.popularmovies.data.MovieDataBase;
import xyz.godi.popularmovies.model.FavoriteMovie;
import xyz.godi.popularmovies.model.Movie;
import xyz.godi.popularmovies.model.Review;
import xyz.godi.popularmovies.model.Video;
import xyz.godi.popularmovies.adapters.ReviewAdapter;
import xyz.godi.popularmovies.adapters.TrailerAdapter;
import xyz.godi.popularmovies.utils.AppBarStateChangeListener;
import xyz.godi.popularmovies.utils.Config;
import xyz.godi.popularmovies.utils.ConstantsUtils;
import xyz.godi.popularmovies.utils.ItemOffsetDecoration;
import xyz.godi.popularmovies.utils.MovieExec;

public class DetailsActivity extends AppCompatActivity {

    public static final String TAG = DetailsActivity.class.getSimpleName();

    // Sharing TAG
    private static final String SHARE_TAG = "#PopularMovieByFarouk";
    // Bind views using ButterKnife
    @BindView(R.id.details_colapsingToolbar)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.details_appBar)
    AppBarLayout appBarLayout;
    @BindView(R.id.headerImage)
    ImageView movieHeaderImage;
    @BindView(R.id.tv_original_title)
    TextView movieTitle;
    @BindView(R.id.date_tv)
    TextView release_date;
    @BindView(R.id.vote_tv)
    TextView vote_count;
    @BindView(R.id.description_content)
    TextView movie_description;
    @BindView(R.id.stars_rb)
    RatingBar ratingBar;
    @BindView(R.id.trailer_recycler)
    RecyclerView trailerView;
    @BindView(R.id.review_recycler)
    RecyclerView reviewsRecycler;
    @BindView(R.id.favoriteButton)
    FloatingActionButton favouriteButton;

    // some us
    private Movie movie;
    private TrailerAdapter trailerAdapter;
    private ReviewAdapter reviewAdapter;
    private MovieDataBase movieDb;
    private Executor executor;
    private boolean isFavorite;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // database instance
        movieDb = MovieDataBase.getDatabase(this);

        // instanciate the executor
        executor = new MovieExec();

        // take data from child activity
        Intent intent = getIntent();
        movie = intent.getParcelableExtra(Movie.TAG);

        // when the favorite button is clicked
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFavoriteClicked();
            }
        });

        // inflate data into views
        populateUI();
        populateTrailers(savedInstanceState);
        populateReviews(savedInstanceState);

    }

    // inflate data in views
    private void populateUI() {
        toolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        toolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorWhite));
        // appbar propriety
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onIdle(AppBarLayout appBarLayout) {
            }

            @Override
            public void onCollapsed(AppBarLayout appBarLayout) {
                toolbar.setTitle(movie.getOriginal_title());
            }

            @Override
            public void onExpanded(AppBarLayout appBarLayout) {
                toolbar.setTitle("");
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            movie = intent.getParcelableExtra(Movie.TAG);

            // set the header image
            // build the image url string first
            String backdrop = ConstantsUtils.MOVIE_POSTER_BASE_URL
                    + ConstantsUtils.MOVIE_POSTER_SIZE_ORIGINAL + movie.getBackdrop_path();

            Picasso.get()
                    .load(backdrop)
                    .placeholder(new ColorDrawable(Color.GRAY))
                    .error(new ColorDrawable(Color.BLACK))
                    .into(movieHeaderImage);

            // set the movie title
            movieTitle.setText(movie.getOriginal_title());

            // set the release date
            release_date.setText(movie.getRelease_date());

            float rating = (float) Math.round(movie.getVote_average() * 10) / 10;

            // set rating stars
            ratingBar.setRating(rating);

            // set the vote count
            vote_count.setText(String.valueOf(movie.getVote_count()));

            // set movie overview
            movie_description.setText(movie.getOverview());

            // check if movie is favorite
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Movie movie1 = movieDb.movieDAO().getMovieById(movie.getId());
                    if (movie1 != null) {
                        isFavorite = true;
                        favouriteButton.setImageResource(R.drawable.ic_favorite_added);
                    } else {
                        isFavorite = false;
                        favouriteButton.setImageResource(R.drawable.ic_favorite_border);
                    }
                }
            });
        }
    }

    /**
     * fetch trailers and populate their views
     */
    private void populateTrailers(Bundle savedInstance) {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        trailerView.setLayoutManager(layoutManager);
        trailerView.setHasFixedSize(true);
        trailerView.setNestedScrollingEnabled(false);

        ItemOffsetDecoration decoration = new
                ItemOffsetDecoration(this, R.dimen.trailer_item_decoration);
        trailerView.addItemDecoration(decoration);

        trailerAdapter = new TrailerAdapter(this);
        trailerView.setAdapter(trailerAdapter);

        if (savedInstance != null && savedInstance.containsKey(Movie.TAG)) {
            trailerAdapter.setItems(savedInstance.<Video>getParcelableArrayList(Movie.TAG));
        } else {
            Service apiService = RetrofitClient.getClient().create(Service.class);

            Call<ApiResponse<Video>> call = apiService.getMovieTrailers(movie.getId(), Config.API_KEY);

            call.enqueue(new Callback<ApiResponse<Video>>() {
                @Override
                public void onResponse(Call<ApiResponse<Video>> call,
                                       Response<ApiResponse<Video>> response) {
                    if (response.isSuccessful()) {
                        List<Video> videos = response.body().results;
                        trailerAdapter.setItems(videos);
                    }
                }

                @Override
                public void onFailure(Call<ApiResponse<Video>> call, Throwable t) {
                }
            });
        }
    }

    /**
     * fetch reviews and populate in the views
     */
    private void populateReviews(Bundle savedInstance) {
        // reviews layout manager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reviewsRecycler.setLayoutManager(layoutManager);
        reviewsRecycler.setHasFixedSize(true);
        reviewsRecycler.setNestedScrollingEnabled(false);

        // set reviews adapter
        reviewAdapter = new ReviewAdapter(this);
        reviewsRecycler.setAdapter(reviewAdapter);

        if (savedInstance != null && savedInstance.containsKey(Movie.TAG)) {
            reviewAdapter.setItems(savedInstance.<Review>getParcelableArrayList(Movie.TAG));
        } else {
            Service apiService = RetrofitClient.getClient().create(Service.class);
            Call<ApiResponse<Review>> call = apiService.getMovieReviews(movie.getId(), Config.API_KEY);

            call.enqueue(new Callback<ApiResponse<Review>>() {
                @Override
                public void onResponse(Call<ApiResponse<Review>> call, Response<ApiResponse<Review>> response) {
                    if (response.isSuccessful()) {
                        List<Review> reviews = response.body().results;
                        reviewAdapter.setItems(reviews);
                    }
                }

                @Override
                public void onFailure(Call<ApiResponse<Review>> call, Throwable t) {
                }
            });
        }
    }

    /**
     * Add Movie to favorite or remove it from
     */
    public void onFavoriteClicked() {
        // snackBar text
        String snackBarText;

        // if the movie already exist
        if (isFavorite) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    movieDb.movieDAO().delete(movie);
                }
            });
            isFavorite = false;

            // set favorite removed icon
            favouriteButton.setImageResource(R.drawable.ic_favorite_border);
            snackBarText = getString(R.string.favorite_removed);
        } else {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    movieDb.movieDAO().insert(movie);
                }
            });
            isFavorite = true;
            // set favorite added icon
            favouriteButton.setImageResource(R.drawable.ic_favorite_added);
            snackBarText = getString(R.string.favorite_added);
        }
        Snackbar.make(coordinatorLayout, snackBarText, Snackbar.LENGTH_SHORT)
                .setAction(R.string.view_favorite, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),FavoritesActivity.class);
                        startActivity(intent);
                    }
                }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share_menu) {
            shareMovie(movie.getOriginal_title() + " is trending now ! " + "\n" + "Read overview : " +
                    movie.getOverview() + "\n" + SHARE_TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareMovie(String text) {
        // set the sharing mime type
        String mimeType = "text/plain";

        // the sharing intent title
        String title = "Share movie with";

        // build the share intent with ShareCompat class
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setText(text)
                .setChooserTitle(title)
                .startChooser();
    }
}