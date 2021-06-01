package com.example.tattooapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class BasicResponse {
    @SerializedName("styles")
    public List<Style> style;

    public BasicResponse(List<Style> style) {
        this.style = style;
    }
}

