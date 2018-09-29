// Generated code from Butter Knife. Do not modify!
package xyz.godi.popularmovies.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import xyz.godi.popularmovies.R;

public class DetailsActivity_ViewBinding implements Unbinder {
  private DetailsActivity target;

  @UiThread
  public DetailsActivity_ViewBinding(DetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailsActivity_ViewBinding(DetailsActivity target, View source) {
    this.target = target;

    target.toolbarLayout = Utils.findRequiredViewAsType(source, R.id.details_colapsingToolbar, "field 'toolbarLayout'", CollapsingToolbarLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.details_appBar, "field 'appBarLayout'", AppBarLayout.class);
    target.movieHeaderImage = Utils.findRequiredViewAsType(source, R.id.headerImage, "field 'movieHeaderImage'", ImageView.class);
    target.movieTitle = Utils.findRequiredViewAsType(source, R.id.tv_original_title, "field 'movieTitle'", TextView.class);
    target.release_date = Utils.findRequiredViewAsType(source, R.id.date_tv, "field 'release_date'", TextView.class);
    target.vote_count = Utils.findRequiredViewAsType(source, R.id.vote_tv, "field 'vote_count'", TextView.class);
    target.movie_description = Utils.findRequiredViewAsType(source, R.id.description_content, "field 'movie_description'", TextView.class);
    target.ratingBar = Utils.findRequiredViewAsType(source, R.id.stars_rb, "field 'ratingBar'", RatingBar.class);
    target.trailerView = Utils.findRequiredViewAsType(source, R.id.trailer_recycler, "field 'trailerView'", RecyclerView.class);
    target.reviewsRecycler = Utils.findRequiredViewAsType(source, R.id.review_recycler, "field 'reviewsRecycler'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbarLayout = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.movieHeaderImage = null;
    target.movieTitle = null;
    target.release_date = null;
    target.vote_count = null;
    target.movie_description = null;
    target.ratingBar = null;
    target.trailerView = null;
    target.reviewsRecycler = null;
  }
}
