package com.example.zxy.testmvvm.kotlin

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log

import com.example.zxy.testmvvm.model.UserBean

import java.util.ArrayList
import java.util.HashMap

/**
 * Created by zxy on 2017/5/3.
 */

class DBManager1(context: Context) {

    private val mDBHelper: MySqlOpenHelper1

    init {
        mDBHelper = MySqlOpenHelper1(context)
    }

    /**
     * 得到extId
     * @return
     */
    val user: List<UserBean> get() {
        val list = ArrayList<UserBean>()
        var mDB: SQLiteDatabase? = null
        var c: Cursor? = null
        try {
            mDB = mDBHelper.writableDatabase
            c = mDB!!.rawQuery("SELECT * FROM user ", null)
            while (c!!.moveToNext()) {
                val u = UserBean()
                u.name.set(c.getString(c.getColumnIndex("name")))
                u.sex.set(c.getString(c.getColumnIndex("sex")))
                list.add(u)
            }
        } catch (e: Exception) {
            Log.e(TAG, "getImg_data 查询数据失败：" + e.toString())
        } finally {
            if (c != null) c.close()
            if (mDB != null) mDB.close()
        }
        return list
    }

    /**添加user */
    fun addUser(name: String, sex: String, age: Int): Boolean {
        var mDB: SQLiteDatabase? = null
        try {
            mDB = mDBHelper.writableDatabase
            // mDB.execSQL("DELETE FROM user");// 插入前先清空已有配置
            mDB!!.execSQL("INSERT INTO user VALUES(null,?,?,?)", arrayOf(name, sex, age))
            Log.e(TAG, "数据插入成功")
            return true
        } catch (e: Exception) {
            Log.e(TAG, "addExtId_data数据插入失败：" + e.toString())
            return false
        } finally {
            if (mDB != null) {
                mDB.close()
            }
        }
    }

    /**
     * 更新user
     */
    fun updateUser(name: String, sex: String, age: Int): Boolean {
        var mDB: SQLiteDatabase? = null
        try {
            mDB = mDBHelper.writableDatabase
            mDB!!.execSQL("UPDATE user set sex = ? ,age=? where name=? ",
                    arrayOf(sex, age, name))
            return true
        } catch (e: Exception) {
            Log.e(TAG, "updateExtIdData数据更新失败：" + e.toString())
            return false
        } finally {
            if (mDB != null) {
                mDB.close()
            }
        }
    }

    fun delUser() {
        var mDB: SQLiteDatabase? = null
        try {
            mDB = mDBHelper.writableDatabase
            mDB!!.execSQL("DELETE FROM user")//
            Log.e(TAG, "数据清除成功")
        } catch (e: Exception) {
            Log.e(TAG, "DELETE user数据删除失败：" + e.toString())
        } finally {
            if (mDB != null) {
                mDB.close()
            }
        }
    }

    companion object {
        private val TAG = DBManager1::class.java.simpleName
    }

}
