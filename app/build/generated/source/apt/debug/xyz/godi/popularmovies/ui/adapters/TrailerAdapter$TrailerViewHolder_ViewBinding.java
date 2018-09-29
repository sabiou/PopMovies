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

public class TrailerAdapter$TrailerViewHolder_ViewBinding implements Unbinder {
  private TrailerAdapter.TrailerViewHolder target;

  @UiThread
  public TrailerAdapter$TrailerViewHolder_ViewBinding(TrailerAdapter.TrailerViewHolder target,
      View source) {
    this.target = target;

    target.trailer_iv = Utils.findRequiredViewAsType(source, R.id.iv_trailer_thumb, "field 'trailer_iv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TrailerAdapter.TrailerViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.trailer_iv = null;
  }
}
