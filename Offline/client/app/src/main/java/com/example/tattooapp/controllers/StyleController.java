package com.example.tattooapp.controllers;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.tattooapp.DI.RetrofitProvider;
import com.example.tattooapp.api.TattooApi;
import com.example.tattooapp.models.BasicResponse;
import com.example.tattooapp.models.Style;
import com.example.tattooapp.views.LoginFragment;
import com.example.tattooapp.views.RegisterFragment;

import java.io.IOException;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class StyleController {

    private RegisterFragment fragment;
    private SharedPreferences sharedPreferences;
    private Retrofit retrofit;
    public MutableLiveData<List<Style>> mutableStyleResponse;

    // constructor to initialize the var
    public StyleController(LoginFragment fragment){
        //this.fragment = fragment;
        //sharedPreferences = fragment.getActivity().getPreferences(Context.MODE_PRIVATE);
        //String tmp = getValueFromSharedPreferences("access_token");
        retrofit = RetrofitProvider.getInstance();
        mutableStyleResponse = new MutableLiveData<>();
    }
    public String getValueFromSharedPreferences(String key) {
        return sharedPreferences.getString(key, "Didn't get value");
    }

    public void getStyles() {
        TattooApi apiService = retrofit.create(TattooApi.class);
        Call<BasicResponse> call = apiService.getStyles();
        call.enqueue(new Callback<BasicResponse>() {
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


    private RequestBody createUser(String name, String email, String password) throws IOException {
        RequestBody res = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("name", name)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build();
        return (res);
    }
}
