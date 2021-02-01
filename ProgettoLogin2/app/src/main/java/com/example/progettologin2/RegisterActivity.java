package com.example.progettologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.Serializable;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, confirmPassword, city, birthdate;
    ImageButton visibilityPassword;
    Button registerButton;
    boolean isPasswordVisible = false;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.editText_CreateUsername_Register);
        password = findViewById(R.id.editText_CreatePassword_Register);
        confirmPassword = findViewById(R.id.editText_ConfirmPassword_Register);
        city = findViewById(R.id.editText_CityUser_Register);
        birthdate = findViewById(R.id.editText_BirthdateUser_Register);
        visibilityPassword = findViewById(R.id.imageButton_VisibilityPassword_Login);
        registerButton = findViewById(R.id.button_RegisterUser_Register_Login);

        //Quando si clicca il pulsante per la registrazione
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameToSave, passwordToSave, confirmingPassword, cityToSave, birthdateToSave;
                usernameToSave  = username.getText().toString();
                passwordToSave  = password.getText().toString();
                confirmingPassword  = confirmPassword.getText().toString();
                cityToSave  = city.getText().toString();
                birthdateToSave  = birthdate.getText().toString();
                if(usernameToSave.length() != 0){
                    if(passwordToSave.length() != 0){
                        if(confirmingPassword.length() != 0 && confirmingPassword.equals(passwordToSave)){
                            if(cityToSave.length() != 0){
                                if(birthdateToSave.length() != 0){
                                    User user = new User(usernameToSave, passwordToSave, cityToSave,
                                            birthdateToSave, false, userId);
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}