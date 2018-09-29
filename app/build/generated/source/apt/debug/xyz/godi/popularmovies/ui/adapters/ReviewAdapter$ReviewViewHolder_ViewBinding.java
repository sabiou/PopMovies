// Generated code from Butter Knife. Do not modify!
package xyz.godi.popularmovies.ui.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import xyz.godi.popularmovies.R;

public class ReviewAdapter$ReviewViewHolder_ViewBinding implements Unbinder {
  private ReviewAdapter.ReviewViewHolder target;

  @UiThread
  public ReviewAdapter$ReviewViewHolder_ViewBinding(ReviewAdapter.ReviewViewHolder target,
      View source) {
    this.target = target;

    target.authorPseudo = Utils.findRequiredViewAsType(source, R.id.author_tv, "field 'authorPseudo'", TextView.class);
    target.contentText = Utils.findRequiredViewAsType(source, R.id.content_tv, "field 'contentText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReviewAdapter.ReviewViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.authorPseudo = null;
    target.contentText = null;
  }
}
