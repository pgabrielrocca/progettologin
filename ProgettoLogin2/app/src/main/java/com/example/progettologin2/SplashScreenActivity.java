package com.example.progettologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        //Timer
        Thread background = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent startApplication = new
                            Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(startApplication);
                } catch (InterruptedException e) {
                }
            }
        };
        background.start();
    }
}