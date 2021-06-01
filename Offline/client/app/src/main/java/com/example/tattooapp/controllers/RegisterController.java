package com.example.tattooapp.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.example.tattooapp.DI.RetrofitProvider;
import com.example.tattooapp.api.TattooApi;
import com.example.tattooapp.models.RegisterResponse;
import com.example.tattooapp.views.RegisterFragment;
import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class RegisterController {

    private RegisterFragment fragment;
    private SharedPreferences sharedPreferences;
    private Retrofit retrofit;

    // constructor to initialize the var
    public RegisterController(RegisterFragment fragment){
        this.fragment = fragment;
        //sharedPreferences = fragment.getActivity().getPreferences(Context.MODE_PRIVATE);
        //String tmp = getValueFromSharedPreferences("access_token");
        retrofit = RetrofitProvider.getInstance();
    }
    public String getValueFromSharedPreferences(String key) {
        return sharedPreferences.getString(key, "Didn't get value");
    }

    public void registerUser(String name, String email, String password)throws IOException {
        TattooApi apiService = retrofit.create(TattooApi.class);

        Log.i("SAN", "entra dintre");

        Call<RegisterResponse> call = apiService.register(name, password, email);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.i("SAN", "entra dintre2");
                if (response.isSuccessful()) {
                    Toast.makeText(fragment.getActivity(), "Upload!", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Log.i("SAN", response.message());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(fragment.getActivity(), "An unknown error has occured.", Toast.LENGTH_SHORT)
                        .show();
                Log.i("SAN", t.getMessage());
                Log.i("SAN", "on failure");
            }
        });
    }


    private RequestBody createUser(String name, String email, String password) throws IOException {
        RequestBody res = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("name", name)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build();
        return (res);
    }
}
