// Generated code from Butter Knife. Do not modify!
package xyz.godi.popularmovies.ui.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import xyz.godi.popularmovies.R;

public class MovieAdapter$MovieViewHolder_ViewBinding implements Unbinder {
  private MovieAdapter.MovieViewHolder target;

  @UiThread
  public MovieAdapter$MovieViewHolder_ViewBinding(MovieAdapter.MovieViewHolder target,
      View source) {
    this.target = target;

    target.poster_iv = Utils.findRequiredViewAsType(source, R.id.poster_iv, "field 'poster_iv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieAdapter.MovieViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.poster_iv = null;
  }
}
