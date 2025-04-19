package com.hxl.androidsr.enity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// 1. 编写用户信息表对应的实体类，该类添加"@Entity"注解
@Entity
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String account; // 账号
    private String password; // 密码

    // 右键->Generate...->Getter and Setter->选择全部字段点OK

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 输入toS->选择带generate via wizard的->点OK

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
