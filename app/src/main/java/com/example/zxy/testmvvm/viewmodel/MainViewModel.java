package com.example.zxy.testmvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zxy.testmvvm.Utils.RecyclerViewClickListener;
import com.example.zxy.testmvvm.Utils.RecyclerViewClickListener2;
import com.example.zxy.testmvvm.databinding.ActivityMainBinding;
import com.example.zxy.testmvvm.model.MainModel;
import com.example.zxy.testmvvm.model.UserBean;
import com.example.zxy.testmvvm.view.MainAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 2017/4/27.
 */

public class MainViewModel extends BaseObservable {
    public ActivityMainBinding activityTesBinding;
    private MainModel mMainModel;

    public UserBean user;
    public MainAdapter adapter;
    public ObservableField<List<UserBean>> dataList = new ObservableField<>();
    public List<UserBean> data = new ArrayList<>();

    public Context context;

    RecyclerViewClickListener recyclerViewClickListener;
    RecyclerViewClickListener2 recyclerViewClickListener2;

    public MainViewModel(Context context, ActivityMainBinding activityTesBinding) {
        this.activityTesBinding = activityTesBinding;
        this.context = context;
        mMainModel = new MainModel(context);
        initListener();
        initUser();
        init();
    }

    private void initListener() {

        recyclerViewClickListener = new RecyclerViewClickListener(context, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "Click " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, "Long Click " + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewClickListener2 = new RecyclerViewClickListener2(context, activityTesBinding.recleView, new RecyclerViewClickListener2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "Click " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, "Long Click " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUser() {
        user = new UserBean();
        user.name.set("aaa");
        user.sex.set("男");
        List<UserBean> list = mMainModel.getUser();
        if (list != null) {
            data = list;
        }
        user.name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(context, "name changed", Toast.LENGTH_SHORT).show();
            }
        });

        CountDownTimer a=null;
    }

    private int type = 0;

//    private void setNewsDetailPhotoIv(String imgSrc) {
//        Glide.with(context).load(imgSrc)
//                .fitCenter()
//                .error(com.jaydenxiao.common.R.drawable.ic_empty_picture)
//                .crossFade().into(newsDetailPhotoIv);
//    }

    private void init() {
        adapter = new MainAdapter(context, data);
        RecyclerView.LayoutManager mLayoutManager = null;
        if (type == 1) {
            mLayoutManager = new LinearLayoutManager(context);
        } else {
            mLayoutManager = new GridLayoutManager(context, 3);
        }

        activityTesBinding.recleView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        activityTesBinding.recleView.setHasFixedSize(true);
//        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
//            }
//        });
        activityTesBinding.recleView.addOnItemTouchListener(recyclerViewClickListener2);
        activityTesBinding.recleView.setAdapter(adapter);
    }


    public void onSaveClick() {
        Toast.makeText(context, "bug" + data.size(), Toast.LENGTH_SHORT).show();
        //data = list;
        Log.i("", "init-----" + data.size());
        String name = activityTesBinding.etUsername.getText().toString();
        String sex = activityTesBinding.etSex.getText().toString();
        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(sex)) {
            mMainModel.add(name, sex, 1);
        }
    }

    public void upData() {
        String name = activityTesBinding.etUsername.getText().toString();
        String sex = activityTesBinding.etSex.getText().toString();
        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(sex)) {
            mMainModel.updata(name, sex, 1);
        }
    }
}
