package com.hxl.androidsr;

import android.app.Application;

import androidx.room.Room;

import com.hxl.androidsr.database.UserDatabase;

import java.util.HashMap;

public class MyApplication extends Application {

    private static MyApplication mApp;
    public HashMap<String, String> infoMap = new HashMap<>();

    // 4. 在自定义的Application类中声明用户数据库的唯一实例
    private UserDatabase userDatabase;

    // 获取类实例
    public static MyApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        // 构建用户数据库的实例
        userDatabase = Room.databaseBuilder(this, UserDatabase.class, "user")
                // 允许迁移数据库（发生数据库变更时，Room默认删除原数据库再创建新数据库。
                // 如此一来原来的记录会丢失，故而要改为迁移方式以便保存原有记录）
                .addMigrations()
                // 允许在主线程中操作数据库（Room默认不能在主线程中操作数据库）（因缺少必要知识，此处先允许）
                .allowMainThreadQueries()
                .build();
    }

    // 获取书籍数据库的实例
    public UserDatabase getUserDB() {
        return userDatabase;
    }
}
