package com.example.tattooapp.provider;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    //Funciona amb el comando "php artisan serve --host=192.168.1.129" al terminal
    public static final String BASE_URL = "http://192.168.1.129:8000/api/";

    //Funciona amb el emulator:
    //public static final String BASE_URL = "http://10.0.2.2:8000/api/";

    private static Retrofit retrofit;
    private static SharedPreferences sharedPreferences;

    //public  static Retrofit getInstance(String token) {
    public static Retrofit getInstance(Fragment fragment) {
        if (retrofit == null) {

            sharedPreferences = fragment.getActivity().getPreferences(Context.MODE_PRIVATE);

            Gson gson = new GsonBuilder().setLenient().create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(chain ->
                    chain.proceed(
                        chain.request()
                            .newBuilder()
                            .addHeader(
                                "Authorization",
                                "Bearer " + sharedPreferences.getString("token", "Oh no :("))
                            .build()
                    )
                )
                .build();

            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                /*   .readTimeout(60, TimeUnit.SECONDS)
                   .connectTimeout(60, TimeUnit.SECONDS)
                   .addInterceptor(chain -> {

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
