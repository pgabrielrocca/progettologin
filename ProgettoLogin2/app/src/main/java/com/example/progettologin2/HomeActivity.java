package com.example.progettologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class HomeActivity extends AppCompatActivity {
    TextView username, password, city, birthdate, linkModify;
    Button logout, userList;
    User userForAuthenticate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = findViewById(R.id.textView_User_Home);
        password = findViewById(R.id.textView_Password_Home);
        city = findViewById(R.id.textView_City_Home);
        birthdate = findViewById(R.id.textView_Data_Home);
        linkModify = findViewById(R.id.textView_ModifyPasswordLink_Home);
        logout = findViewById(R.id.button_Logout_Home);
        userList = findViewById(R.id.button_UserList_Home);

        Intent intente = getIntent();
        Serializable obj = intente.getSerializableExtra("com.example.progettologin2.User");
        userForAuthenticate = (User) obj;

        username.setText(((User) obj).getUsername());
        password.setText(((User) obj).getPassword());
        city.setText(((User) obj).getCity());
        birthdate.setText(((User) obj).getBirthdate());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        linkModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ModifyPassword.class);
                intent.putExtra("com.example.progettologin2.User", userForAuthenticate);
                startActivity(intent);
            }
        });

        if(userForAuthenticate.isAdmin()){
            userList.setVisibility(View.VISIBLE);
        }else{
            userList.setVisibility(View.GONE);
        }

        userList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, UserListActivity.class);
                intent.putExtra("com.example.progettologin2.User", userForAuthenticate);
                startActivity(intent);
            }
        });
    }
}