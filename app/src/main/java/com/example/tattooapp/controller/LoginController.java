package com.example.tattooapp.controller;


import android.content.SharedPreferences;

import com.example.tattooapp.views.LoginFragment;

import retrofit2.Retrofit;

public class LoginController {

    private SharedPreferences sharedPreferences;
    private Retrofit retrofit;

    // constructor to initialize the var
    public LoginController(){
       /* sharedPreferences = fragment.getActivity().getPreferences(Context.MODE_PRIVATE);
        String tmp = getValueFromSharedPreferences("access_token");
        retrofit = RetrofitProvider.getInstance(tmp);*/
    }
}
