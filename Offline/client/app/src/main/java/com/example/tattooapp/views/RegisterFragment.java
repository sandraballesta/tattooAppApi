package com.example.tattooapp.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tattooapp.R;
import com.example.tattooapp.controllers.RegisterController;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

public class RegisterFragment extends Fragment {

    RegisterController controller;
    private Button btnToLogin;
    private Button btnRegister;
  /*  private TextInputEditText email;
    private TextInputEditText  password;
    private TextInputEditText  name;*/
    private String name;
    private String email;
    private String password;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_register, container, false);
        setLayout();
        btnToLogin.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.toLogin);
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        TextInputLayout vemail = view.findViewById(R.id.email);
                        email = vemail.getEditText().getText().toString().trim();
                        TextInputLayout vpassword = view.findViewById(R.id.password);
                        password = vpassword.getEditText().getText().toString().trim();
                        TextInputLayout vname = view.findViewById(R.id.name);
                        name = vname.getEditText().getText().toString().trim();

                        controller.registerUser(name, email, password);
                    } catch (IOException e) {
                        Log.i("TRYING TO REGISTER", "whats up");
                        e.printStackTrace();
                    }
                }
        });

        return this.view;
    }



    private void setLayout(){
        controller = new RegisterController(this);
        btnToLogin = view.findViewById(R.id.btnToLogin);
        btnRegister = view.findViewById(R.id.btnRegister);



    }
}