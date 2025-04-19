package com.hxl.androidsr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hxl.androidsr.dao.UserDao;
import com.hxl.androidsr.enity.UserInfo;
import com.hxl.androidsr.utils.LoginStatusManager;
import com.hxl.androidsr.utils.ToastUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_account;
    private EditText et_pwd;
    private EditText et_pwd2;
    private Button btn_register;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LoginStatusManager.saveLoginStatus(this, true);

        findViewById(R.id.iv_back).setOnClickListener(this);

        et_account = findViewById(R.id.et_account);
        et_pwd = findViewById(R.id.et_pwd);
        et_pwd2 = findViewById(R.id.et_pwd2);
        btn_register = findViewById(R.id.btn_register);

        // 从App实例中获取唯一的书籍持久化对象
        userDao = MyApplication.getInstance().getUserDB().userDao();
    }

    @Override
    public void onClick(View v) {
        String account = et_account.getText().toString();
        String pwd = et_pwd.getText().toString();
        String pwd2 = et_pwd2.getText().toString();
        if (v.getId() == R.id.iv_back) {
            finish();
        } else if (v.getId() == R.id.btn_register) {
            // 5. 在操作用户信息表的地方获取数据表的持久化对象
            // 以下声明一个书籍信息对象，并填写它的各字段值
            UserInfo u1 = new UserInfo();
            u1.setAccount(account);
            u1.setPassword(pwd);
            userDao.insert(u1);
            ToastUtil.show(this, "添加成功");
        }
    }
}