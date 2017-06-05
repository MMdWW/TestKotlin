package com.example.zxy.testmvvm.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zxy on 2017/5/3.
 */

public class MySqlOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mvvm";
    private static final int DB_VERSION = 1;

    public MySqlOpenHelper(Context context) {
        super(context.getApplicationContext(), DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DataBaseHelper", "数据库创建");
        db.execSQL("CREATE TABLE IF NOT EXISTS user (id integer primary key autoincrement, name varchar(10),sex varchar(10), age INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("DataBaseHelper", "数据库更新");

    }
}
