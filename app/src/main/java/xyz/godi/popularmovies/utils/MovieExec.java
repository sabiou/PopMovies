package xyz.godi.popularmovies.utils;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class MovieExec implements Executor {

    @Override
    public void execute(@NonNull Runnable command) {
        new Thread(command).start();
    }
}
