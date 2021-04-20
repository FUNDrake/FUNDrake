package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenIntro extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_intro);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreenIntro.this,MainActivity.class);
                SplashScreenIntro.this.startActivity(mainIntent);
                SplashScreenIntro.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}