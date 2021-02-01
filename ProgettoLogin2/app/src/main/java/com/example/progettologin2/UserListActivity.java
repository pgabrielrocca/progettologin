package com.example.progettologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.progettologin2.LoginActivity.setUserArrayList;

public class UserListActivity extends AppCompatActivity {
    Button home, promote;
    User userForAuthenticate;
    ArrayList<User> archive = new ArrayList<>();
    ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        home = findViewById(R.id.button_Home_UserList);
        promote = findViewById(R.id.button_PromoteAdmin_UserList);
        userList = findViewById(R.id.listView_UserList_UserList);

        Intent intente = getIntent();
        Serializable obj = intente.getSerializableExtra("com.example.progettologin2.User");
        userForAuthenticate = (User) obj;

        ArrayAdapter<User> userListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, archive);
        userList.setAdapter(userListAdapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User selectedFromList = (User) (userList.getItemAtPosition(position));
                userForAuthenticate.setUsername(selectedFromList.getUsername());
                userForAuthenticate.setPassword(selectedFromList.getPassword());
                userForAuthenticate.setCity(selectedFromList.getCity());
                userForAuthenticate.setBirthdate(selectedFromList.getBirthdate());
                userForAuthenticate.setAdmin(selectedFromList.isAdmin());
            }
        });{
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        promote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userForAuthenticate.setAdmin(true);
                archive.set(userForAuthenticate.getId(), userForAuthenticate);
                setUserArrayList(archive);
            }
        });
    }
}