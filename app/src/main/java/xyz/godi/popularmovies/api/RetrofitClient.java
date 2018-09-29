package xyz.godi.popularmovies.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.godi.popularmovies.utils.ConstantsUtils;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        // if our retrofit object is null
        // build one
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantsUtils.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        // then return it
        return retrofit;
    }
}