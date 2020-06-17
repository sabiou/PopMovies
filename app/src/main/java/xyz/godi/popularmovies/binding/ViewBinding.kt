package xyz.godi.popularmovies.binding

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.skydoves.whatif.whatIfNotNull

/**
 * Created by Farouk on 12/06/20.
 */

@BindingAdapter("toast")
fun bindToast(view: View, text: LiveData<String>) {
    text.value.whatIfNotNull {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) {
    view.isGone = shouldBeGone
}

@BindingAdapter("onBackPressed")
fun bindOnBackPressed(view: View, finish: Boolean) {
    val context = view.context
    if (finish && context is Activity) {
        view.setOnClickListener {
            context.onBackPressed()
        }
    }
}