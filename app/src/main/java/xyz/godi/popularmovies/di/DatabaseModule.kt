package xyz.godi.popularmovies.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import xyz.godi.popularmovies.data.MovieDao
import xyz.godi.popularmovies.data.MovieDataBase
import javax.inject.Singleton

/**
 * Created by Farouk on 12/06/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
        @Provides
        @Singleton
        fun provideAppDatabase(application: Application): MovieDataBase {
            return Room
                    .databaseBuilder(application, MovieDataBase::class.java, "movies.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        }

        @Provides
        @Singleton
        fun provideMovieDao(dataBase: MovieDataBase): MovieDao {
            return dataBase.movieDao()
        }
}