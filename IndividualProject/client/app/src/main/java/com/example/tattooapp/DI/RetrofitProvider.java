package com.example.tattooapp.DI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitProvider {

    public static final String BASE_URL = "http://localhost:8000/";
    private static Retrofit retrofit;

    public  static Retrofit getInstance(String token) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(60, TimeUnit.SECONDS)
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .addInterceptor(chain -> {
                            Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token).build();
                            return (chain.proceed(request));
                        }).build())
                .build();
        return retrofit;
    }
}
