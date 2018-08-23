package com.example.batuhandemir.volleyballcounter.UI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent gp = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(gp);
    }
}
