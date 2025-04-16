package com.hxl.androidsr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hxl.androidsr.utils.LoginStatusManager;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LoginStatusManager.saveLoginStatus(this, true);
    }
}