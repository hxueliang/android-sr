package com.hxl.androidsr.database;

// 3. 编写书籍信息表对应的数据库类，该类从RoomDatabase派生而来，该类添加"@Database"注解

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hxl.androidsr.dao.UserDao;
import com.hxl.androidsr.enity.UserInfo;

/**
 * entities 表示该数据库有哪些表，
 * version 表示数据库的版本号
 * exportSchema 表示是否导出数据库信息的json串，建议设为false，若设置为true还需要指定json文件的保存路径
 */
@Database(entities = {UserInfo.class}, version = 1, exportSchema = true)
public abstract class UserDatabase extends RoomDatabase {
    // 获取该数据库中某张表的持久化对象
    public abstract UserDao userDao();
}
