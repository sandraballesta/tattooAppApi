package com.example.tattooapp.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tattooapp.api.TattooApi;
import com.example.tattooapp.models.RegisterResponse;
import com.example.tattooapp.provider.RetrofitProvider;
import com.example.tattooapp.views.RegisterFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterController {

    private final Fragment fragment;
    private final SharedPreferences sharedPreferences;
    private final TattooApi apiService;

    // constructor to initialize the var
    public RegisterController(Fragment fragment) {
        this.fragment = fragment;
        apiService = RetrofitProvider.getInstance(fragment).create(TattooApi.class);
        sharedPreferences = fragment.getActivity().getPreferences(Context.MODE_PRIVATE);
    }

    public void registerUser(String name, String email, String password) {

        Log.i("SAN", "entra dintre");

        Call<RegisterResponse> call = apiService.register(name, password, email);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.i("SAN", "entra dintre2");
                if (response.isSuccessful()) {
                    Toast.makeText(fragment.getActivity(), "Upload!", Toast.LENGTH_SHORT)
                        .show();
                    saveToken(response);
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

    private void saveToken(Response<RegisterResponse> response) {
        sharedPreferences.edit().putString("token", response.body().getToken()).apply();
    }
}
