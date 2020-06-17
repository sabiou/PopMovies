package xyz.godi.popularmovies.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Farouk on 12/06/20.
 */
class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        // Timber.d(request.toString())
        return chain.proceed(request)
    }
}