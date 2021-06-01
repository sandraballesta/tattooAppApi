package com.example.tattooapp.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tattooapp.R;
import com.example.tattooapp.controllers.LoginController;
import com.example.tattooapp.controllers.StyleController;

import java.io.IOException;

public class LoginFragment extends Fragment {

    private static final String DUMMY_USER_ID = "0000000000";
    private static final String DUMMY_PASSWORD = "dummy_password";
    private Button btnTest;
    private Button btnLogin;
    private Button btnToRegister;
    private TextView email;
    private TextView password;
    private View view;
    LoginController controller;
    StyleController styleController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_login, container, false);
        setLayout();

        styleController = new StyleController(this);

        btnTest.setOnClickListener(new View.OnClickListener() {
            //Navigation.findNavController(view).navigate(R.id.toTest);
            @Override
            public void onClick(View v) {
                try {
                    styleController.getStyles();
                } catch (Exception e) {
                    Log.i("TRYING TO REGISTER", "whats up");
                    e.printStackTrace();
                }
            }
        });

        btnToRegister.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.toRegister);
        });


        return this.view;
    }

    //Initialise Mutables
    private void setMutableVariables() {
        //Mutable for test response
        styleController.mutableStyleResponse.observe(getViewLifecycleOwner(), data -> {
            // what to do with the data....
        });
    }


    private void setLayout(){
        controller = new LoginController(this);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnTest = view.findViewById(R.id.btnTest);
        btnToRegister = view.findViewById(R.id.btnToRegister);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

    }


}