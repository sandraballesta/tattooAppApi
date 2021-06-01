package com.example.tattooapp.controller;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import com.example.tattooapp.api.TattooApi;
import com.example.tattooapp.models.BasicResponse;
import com.example.tattooapp.models.Style;
import com.example.tattooapp.provider.RetrofitProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StyleController {

    private final TattooApi apiService;

    public MutableLiveData<List<Style>> mutableStyleResponse;

    public StyleController(Fragment fragment) {
        apiService = RetrofitProvider.getInstance(fragment).create(TattooApi.class);
        mutableStyleResponse = new MutableLiveData<>();
    }

    public void getStyles() {
        apiService.getStyles().enqueue(new Callback<BasicResponse>() {
            @Override
            public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                int statusCode = response.code();
                Log.i("=======================", "onResponse: " + response.body().style.get(0).name);
                //mutableStyleResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BasicResponse> call, Throwable t) {
                // Log error here since request failed
                Log.i("=======================", "onResponse FAILED: " + t.getMessage());
            }
        });
    }
}
