package com.example.tattooapp.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tattooapp.R;

public class LoginFragment extends Fragment {

    private static final String DUMMY_USER_ID = "0000000000";
    private static final String DUMMY_PASSWORD = "dummy_password";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    private void setLayout(){
/*        controller = new UploadController(this);
        imageView = view.findViewById(R.id.imageView);
        buttonBrowse = view.findViewById(R.id.buttonBrowse);
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        buttonUpload = view.findViewById(R.id.buttonUpload);*/
    }
}