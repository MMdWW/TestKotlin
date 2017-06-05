package com.example.zxy.testmvvm.Utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.zxy.testmvvm.R;
import com.example.zxy.testmvvm.model.UserBean;
import com.example.zxy.testmvvm.view.MainAdapter;

import java.util.List;

/**
 * Created by zxy on 2017/5/2.
 */

public class BindAdapterUtils {
    @BindingAdapter({"data"})
    public static void bindData(RecyclerView recyclerView, List<UserBean> data) {
        recyclerView.notify();
    }

    @BindingAdapter({"adapter"})
    public static void bindAdapter(RecyclerView recyclerView, MainAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
