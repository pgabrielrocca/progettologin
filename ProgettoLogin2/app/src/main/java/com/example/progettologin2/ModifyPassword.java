package com.example.progettologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.progettologin2.LoginActivity.getUserArrayList;
import static com.example.progettologin2.LoginActivity.setUserArrayList;

public class ModifyPassword extends AppCompatActivity {
    TextView username, password, newPassword, confirmPassword;
    Button updatePassword, home;
    User userForAuthenticate;

    ArrayList<User> archive = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password);
        username = findViewById(R.id.textView_Username_Modify);
        password = findViewById(R.id.textView_Password_Modify);
        newPassword = findViewById(R.id.editText_NewPassword_Modify);
        confirmPassword = findViewById(R.id.editText_ConfirmPassword_Modify);
        updatePassword = findViewById(R.id.button_UpdatePassword_Modify);
        home = findViewById(R.id.button_Home_Modify);

        archive = getUserArrayList();

        Intent intente =getIntent();
        Serializable obj = intente.getSerializableExtra("com.example.progettologin2.User");
        userForAuthenticate = (User) obj;

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyPassword.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        updatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPasswordToSave, confirmingPassword;
                newPasswordToSave  = password.getText().toString();
                confirmingPassword  = confirmPassword.getText().toString();
                if(newPasswordToSave.length() != 0){
                    if(confirmingPassword.length() != 0 && confirmingPassword.equals(newPasswordToSave)){
                        userForAuthenticate.setPassword(confirmingPassword);
                        archive.set(userForAuthenticate.getId(), userForAuthenticate);
                        setUserArrayList(archive);
                    }
                }
            }
        });
    }
}