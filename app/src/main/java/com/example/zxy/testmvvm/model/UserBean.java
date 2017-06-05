package com.example.zxy.testmvvm.model;

import android.databinding.ObservableField;

/**
 * Created by zxy on 2017/4/26.
 */

public class UserBean {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> sex = new ObservableField<>();

    @Override
    public String toString() {
        return "UserBean{" +
                "name=a" + name.get() +
                ", sex=" + sex.get() +
                '}';
    }
}
