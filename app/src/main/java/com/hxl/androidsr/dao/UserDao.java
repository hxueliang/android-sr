package com.hxl.androidsr.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.hxl.androidsr.enity.UserInfo;

// 2. 编写用户信息表对应的持久化类，该类添加"@Dao"注解
@Dao
public interface UserDao {
    @Insert
    void insert(UserInfo... book);

    // 根据账号查询用户
    @Query("SELECT * FROM UserInfo WHERE account = :account ORDER BY id DESC limit 1")
    UserInfo queryByName(String account);
}
