package com.example.zxy.testmvvm.model;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.zxy.testmvvm.view.MainAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 2017/4/27.
 */

public class MainModel {
    private DBManager mDBManager;

    public MainModel(Context context){
        mDBManager=new DBManager(context);
    }

    public void add(String name,String sex,int age){
        mDBManager.addUser(name,sex,age);
    }

    public void updata(String name,String sex,int age){
        mDBManager.updateUser(name,sex,age);
    }

    public List<UserBean> getUser(){
        return mDBManager.getUser();
    }

    public void delUser(){
         mDBManager.delUser();
    }


}
