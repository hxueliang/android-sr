package com.hxl.androidsr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hxl.androidsr.dao.UserDao;
import com.hxl.androidsr.enity.UserInfo;
import com.hxl.androidsr.utils.ToastUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_account;
    private EditText et_pwd;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 去注册账号
        findViewById(R.id.tv_register).setOnClickListener(this);

        // 登录
        findViewById(R.id.btn_login).setOnClickListener(this);

        et_account = findViewById(R.id.et_account);
        et_pwd = findViewById(R.id.et_pwd);

        // 从App实例中获取唯一的书籍持久化对象
        userDao = MyApplication.getInstance().getUserDB().userDao();
    }

    @Override
    public void onClick(View v) {
        String account = et_account.getText().toString();
        String pwd = et_pwd.getText().toString();

        if (v.getId() == R.id.tv_register) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_login) {
            UserInfo u1 = new UserInfo();
            u1.setAccount(account);
            u1.setPassword(pwd);
            UserInfo u = userDao.queryByName(account);
            if (u.getAccount().equals(account) && u.getPassword().equals(pwd)) {
                ToastUtil.show(this, "登录成功，自动跳转首页");
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                ToastUtil.show(this, "登录失败，确认用户名和密码是否正确");
            }
        }
    }
}