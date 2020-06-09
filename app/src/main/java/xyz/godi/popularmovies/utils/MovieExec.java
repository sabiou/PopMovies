package xyz.godi.popularmovies.utils;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Thread executor class
 */

public class MovieExec implements Executor {

    @Override
    public void execute(@NonNull Runnable command) {
        new Thread(command).start();
    }
}
