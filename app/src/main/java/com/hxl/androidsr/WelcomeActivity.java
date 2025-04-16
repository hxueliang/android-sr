package com.hxl.androidsr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hxl.androidsr.utils.LoginStatusManager;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final TextView tv_count = findViewById(R.id.tv_count);

        // 设置倒计时总时长为 3 秒，间隔为 1 秒
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                // 每秒更新一次倒计时显示
                tv_count.setText(millisUntilFinished / 1000 + "秒");
            }

            public void onFinish() {
                // 倒计时结束时的操作
                tv_count.setText("0秒");

                final Intent intent = new Intent();
                final boolean loginStatus = LoginStatusManager.getLoginStatus(WelcomeActivity.this);
                final Class<? extends AppCompatActivity> aClass =
                        loginStatus ? HomeActivity.class : RegisterActivity.class;
                intent.setClass(WelcomeActivity.this, aClass);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}