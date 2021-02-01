package com.example.progettologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button accessButton;
    TextView linkRegister;
    static boolean isSuperUserCreated;
    User userForAuthenticate;
    private static ArrayList<User> userArrayList;

    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public static void setUserArrayList(ArrayList<User> userArrayList) {
        LoginActivity.userArrayList = userArrayList;
    }

    public int getIdByUsername(ArrayList<User> userArrayList, User userToReset) {
        for (User user : userArrayList){
            if (user.getUsername().equals(user.getUsername())) {
                return user.getId();
            }
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editText_InsertUsername_Login);
        password = findViewById(R.id.editText_InsertPassword_Login);
        accessButton = findViewById(R.id.button_Access_Login_HomeUser);
        linkRegister = findViewById(R.id.textView_LinkRegister_Login_Register);

        if(newPasswordToSave.length() != 0){
            if(confirmingPassword.length() != 0 && confirmingPassword.equals(newPasswordToSave)){

    }
}