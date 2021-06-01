package com.example.tattooapp.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    public String id;


    public User(String id) {
        this.id = id;
    }
}
