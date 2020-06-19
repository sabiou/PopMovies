package xyz.godi.popularmovies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.godi.popularmovies.BuildConfig
import xyz.godi.popularmovies.network.HttpRequestInterceptor
import xyz.godi.popularmovies.network.TmdbClient
import xyz.godi.popularmovies.network.TmdbService
import javax.inject.Singleton

/**
 * Created by Farouk on 12/06/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpRequestInterceptor())
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideTmdbService(retrofit: Retrofit): TmdbService {
        return retrofit.create(TmdbService::class.java)
    }

    @Provides
    @Singleton
    fun provideTmdbClient(pokedexService: TmdbService): TmdbClient {
        return TmdbClient(pokedexService)
    }
}