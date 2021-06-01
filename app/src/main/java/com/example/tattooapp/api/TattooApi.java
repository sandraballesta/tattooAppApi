package com.example.tattooapp.api;

import com.example.tattooapp.models.BasicResponse;
import com.example.tattooapp.models.RegisterResponse;
import com.example.tattooapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TattooApi {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("getStyles")
    Call<BasicResponse> getStyles();

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> register(
            @Field("name") String name,
            @Field("password") String password,
            @Field("email") String email
    );
}
