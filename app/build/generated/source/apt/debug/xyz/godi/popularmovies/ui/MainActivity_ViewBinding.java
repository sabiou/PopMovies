// Generated code from Butter Knife. Do not modify!
package xyz.godi.popularmovies.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import xyz.godi.popularmovies.R;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.homeLayout = Utils.findRequiredViewAsType(source, R.id.mainLayout, "field 'homeLayout'", FrameLayout.class);
    target.movie_recycler = Utils.findRequiredViewAsType(source, R.id.movie_rv, "field 'movie_recycler'", RecyclerView.class);
    target.loading_spinner = Utils.findRequiredViewAsType(source, R.id.loading_spinner, "field 'loading_spinner'", ProgressBar.class);
    target.emptyView_tv = Utils.findRequiredViewAsType(source, R.id.empty_view, "field 'emptyView_tv'", TextView.class);
    target.no_internet_iv = Utils.findRequiredViewAsType(source, R.id.no_internet_iv, "field 'no_internet_iv'", ImageView.class);
    target.swipeRefresh = Utils.findRequiredViewAsType(source, R.id.swiperefresh, "field 'swipeRefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeLayout = null;
    target.movie_recycler = null;
    target.loading_spinner = null;
    target.emptyView_tv = null;
    target.no_internet_iv = null;
    target.swipeRefresh = null;
  }
}
