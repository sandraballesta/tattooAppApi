package com.example.tattooapp.DI;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitProvider {

    //Funciona amb el comando "php artisan serve --host=192.168.1.129" al terminal
    public static final String BASE_URL = "http://192.168.1.129:8000/api/";

    //Funciona amb el emulator:
    //public static final String BASE_URL = "http://10.0.2.2:8000/api/";

    private static Retrofit retrofit;

    //public  static Retrofit getInstance(String token) {
    public  static Retrofit getInstance() {
        if (retrofit == null) {

            Gson gson = new GsonBuilder().setLenient().create();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    /*   .readTimeout(60, TimeUnit.SECONDS)
                       .connectTimeout(60, TimeUnit.SECONDS)
                       .addInterceptor(chain -> {
                           Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token).build();
                           return (chain.proceed(request));
                       })*///.build())
                    .build();
        }

        return retrofit;
    }

    public static void createToast(Context context, String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_LONG).show();
    }
}
