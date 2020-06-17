package xyz.godi.popularmovies.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import xyz.godi.popularmovies.BuildConfig
import xyz.godi.popularmovies.R

/**
 * Created by Farouk on 12/06/20.
 */

/**
 * To be implemented by components that host top-level navigation destinations.
 */
interface NavigationHost {

    /** Called by MainNavigationFragment to setup it's toolbar with the navigation controller. */
    fun registerToolbarWithNavigation(toolbar: Toolbar)
}

/**
 * To be implemented by main navigation destinations shown by a [NavigationHost].
 */
interface NavigationDestination {

    /** Called by the host when the user interacts with it. */
    fun onUserInteraction() {}
}

open class MainNavigationFragment: Fragment(), NavigationDestination {
    protected var navigationHost: NavigationHost? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost) {
            navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // If we have a toolbar and we are attached to a proper navigation host, set up the toolbar
        // navigation icon.
        val host = navigationHost ?: return
        val mainToolbar: Toolbar = view.findViewById(R.id.main_toolbar) ?: return
        mainToolbar.apply {
            host.registerToolbarWithNavigation(this)
        }
    }
}