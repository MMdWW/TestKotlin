package com.example.zxy.testmvvm.kotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

/**
 * Created by zxy on 2017/5/3.
 */

class MySqlOpenHelper1(context: Context) : SQLiteOpenHelper(context.applicationContext, MySqlOpenHelper1.DB_NAME, null, MySqlOpenHelper1.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        Log.e("DataBaseHelper", "数据库创建")
        db.execSQL("CREATE TABLE IF NOT EXISTS user (id integer primary key autoincrement, name varchar(10),sex varchar(10), age INTEGER)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.e("DataBaseHelper", "数据库更a新")

    }

    companion object {
        private val DB_NAME = "mvvm"
        private val DB_VERSION = 1
    }
}
