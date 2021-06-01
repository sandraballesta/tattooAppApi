package com.example.tattooapp.controllers;


import android.content.SharedPreferences;

import com.example.tattooapp.views.LoginFragment;
import com.example.tattooapp.views.RegisterFragment;

import retrofit2.Retrofit;

public class LoginController {

    private LoginFragment fragment;
    private SharedPreferences sharedPreferences;
    private Retrofit retrofit;

    // constructor to initialize the var
    public LoginController(LoginFragment fragment){
        this.fragment = fragment;
       /* sharedPreferences = fragment.getActivity().getPreferences(Context.MODE_PRIVATE);
        String tmp = getValueFromSharedPreferences("access_token");
        retrofit = RetrofitProvider.getInstance(tmp);*/
    }
}
