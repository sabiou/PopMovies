package xyz.godi.popularmovies.utils;

import com.google.android.material.appbar.AppBarLayout;

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State currentState = State.IDLE;

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (currentState != State.EXPANDED) {
                onExpanded(appBarLayout);
            }
            currentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (currentState != State.COLLAPSED) {
                onCollapsed(appBarLayout);
            }
            currentState = State.COLLAPSED;
        } else {
            if (currentState != State.IDLE) {
                onIdle(appBarLayout);
            }
            currentState = State.IDLE;
        }
    }

    public abstract void onIdle(AppBarLayout appBarLayout);

    public abstract void onCollapsed(AppBarLayout appBarLayout);

    public abstract void onExpanded(AppBarLayout appBarLayout);
}
