package xyz.godi.popularmovies.network

import okhttp3.Interceptor
import okhttp3.Response
import xyz.godi.popularmovies.BuildConfig

/**
 * Created by Farouk on 12/06/20.
 */
class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
                //.addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()
        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        // Timber.d(request.toString())
        return chain.proceed(request)
    }
}