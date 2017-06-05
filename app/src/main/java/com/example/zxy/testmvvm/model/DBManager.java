package com.example.zxy.testmvvm.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 2017/5/3.
 */

public class DBManager {
    private final static String TAG = DBManager.class.getSimpleName();
    private MySqlOpenHelper mDBHelper;
    public DBManager(Context context){
        mDBHelper=new MySqlOpenHelper(context);
    }
    /**
     * 得到extId
     * @return
     */
    public  List<UserBean> getUser() {
        List<UserBean> list=new ArrayList<>();
        Map<String, Object> config = new HashMap<String, Object>();
        SQLiteDatabase mDB = null;
        Cursor c = null;
        try {
            mDB = mDBHelper.getWritableDatabase();
            c = mDB.rawQuery("SELECT * FROM user ", null);
            while (c.moveToNext()) {
                UserBean u=new UserBean();
                u.name.set(c.getString(c.getColumnIndex("name")));
                u.sex.set(c.getString(c.getColumnIndex("sex")));
//                config.put("id", c.getString(c.getColumnIndex("id")));
//                config.put("name", c.getString(c.getColumnIndex("name")));
//                config.put("sex", c.getString(c.getColumnIndex("sex")));
//                config.put("age", c.getString(c.getColumnIndex("age")));
                list.add(u);
            }

        } catch (Exception e) {
            Log.e(TAG, "getImg_data 查询数据失败：" + e.toString());
        } finally {
            if (c != null) {
                c.close();
            }
            if (mDB != null) {
                mDB.close();
            }
        }
        return list;
    }

    /**添加user*/
    public boolean addUser(String name,String sex,int age){
        SQLiteDatabase mDB = null;
        try {
            mDB = mDBHelper.getWritableDatabase();
           // mDB.execSQL("DELETE FROM user");// 插入前先清空已有配置
            mDB.execSQL("INSERT INTO user VALUES(null,?,?,?)", new Object[]{name,sex,age});
            Log.e(TAG,"数据插入成功");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "addExtId_data数据插入失败：" + e.toString());
            return false;
        } finally {
            if (mDB != null) {
                mDB.close();
            }
        }
    }
    /**
     * 更新user
     */
    public boolean updateUser(String name,String sex,int age) {
        SQLiteDatabase mDB = null;
        try {
            mDB = mDBHelper.getWritableDatabase();
            mDB.execSQL("UPDATE user set sex = ? ,age=? where name=? ",
                    new Object[]{sex, age,name});
            return true;
        } catch (Exception e) {
            Log.e(TAG, "updateExtIdData数据更新失败：" + e.toString());
            return false;
        } finally {
            if (mDB != null) {
                mDB.close();
            }
        }

//        ContentValues cv=new ContentValues();
//        String[] args={name};
//
//        cv.put("sex", sex);
//        cv.put("age", age);
//
//        mDBHelper.getWritableDatabase().update("restaurants", cv, "name=?", args);
    }

    public void delUser(){
        SQLiteDatabase mDB = null;
        try {
            mDB = mDBHelper.getWritableDatabase();
            mDB.execSQL("DELETE FROM user");//
            Log.e(TAG, "数据清除成功");
        } catch (Exception e) {
            Log.e(TAG, "DELETE user数据删除失败：" + e.toString());
        } finally {
            if (mDB != null) {
                mDB.close();
            }
        }
    }

}
