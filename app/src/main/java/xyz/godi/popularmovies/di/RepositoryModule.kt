package xyz.godi.popularmovies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import xyz.godi.popularmovies.data.MovieDao
import xyz.godi.popularmovies.network.TmdbClient
import xyz.godi.popularmovies.repository.MainRepository

/**
 * Created by Farouk on 12/06/20.
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideMainRepository(
            tmdbClient: TmdbClient,
            movieDao: MovieDao
    ): MainRepository {
        return MainRepository(tmdbClient, movieDao)
    }
}