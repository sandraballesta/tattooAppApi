package com.example.tattooapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.tattooapp.R;
import com.example.tattooapp.controller.RegisterController;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

  private RegisterController controller;

  private Button btnToLogin;
  private Button btnRegister;

  private TextInputLayout email;
  private TextInputLayout password;
  private TextInputLayout name;

  private View view;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    this.view = inflater.inflate(R.layout.fragment_register, container, false);

    controller = new RegisterController(this);

    setLayout();

    btnToLogin.setOnClickListener(v ->
        Navigation.findNavController(view).navigate(R.id.toLogin)
    );

    btnRegister.setOnClickListener(v -> {
      String emailValue = email.getEditText().getText().toString().trim();
      String passwordValue = password.getEditText().getText().toString().trim();
      String nameValue = name.getEditText().getText().toString().trim();

      controller.registerUser(nameValue, emailValue, passwordValue);
    });

    return this.view;
  }

  private void setLayout() {
    btnToLogin = view.findViewById(R.id.btnToLogin);
    btnRegister = view.findViewById(R.id.btnRegister);

    email = view.findViewById(R.id.email);
    password = view.findViewById(R.id.password);
    name = view.findViewById(R.id.name);
  }
}