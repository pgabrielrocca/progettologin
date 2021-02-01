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
    private boolean usernameFound = true, correctPassword = true;
    static boolean isAdminCreated = false;
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

        if (!isAdminCreated){
            User admin = new User("admin", "admin", true);
            ArrayList<User> firstList = new ArrayList<>();
            firstList.add(admin);
            setUserArrayList(firstList);
            isAdminCreated = true;
        }

        accessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setPassword(password.getText().toString());
                user.setUsername(username.getText().toString());
                controllUsername(user);
            }
            private void startHome(User user){
                Intent intent = new Intent (LoginActivity.this, HomeActivity.class);
                userForAuthenticate.setUsername(user.getUsername());
                userForAuthenticate.setPassword(user.getPassword());
                userForAuthenticate.setCity(user.getCity());
                userForAuthenticate.setBirthdate(user.getBirthdate());
                userForAuthenticate.setAdmin(user.isAdmin());
                intent.putExtra("com.example.progettologin2.User", userForAuthenticate);
                startActivity(intent);
            }
            private void controllUsername(User user){
                if(username.getText().toString().length() != 0) {
                    for (User userToScan: getUserArrayList()){
                        if (username.getText().toString().equals(userToScan.getUsername())){
                            controllPassword(userToScan);
                        }
                        username.setError("Username non trovato");
                    }
                }
                username.setError("Campo vuoto");
            }
            private void controllPassword(User user){
                if (password.getText().toString().length() != 0) {
                    if (password.getText().toString().equals(user.getPassword())){
                        startHome(user);
                    }
                    password.setError("Password errata");
                }
                password.setError("Campo vuoto");
            }
        });
    }
}