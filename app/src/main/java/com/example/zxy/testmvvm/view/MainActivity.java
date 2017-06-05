package com.example.zxy.testmvvm.view;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.zxy.testmvvm.R;
import com.example.zxy.testmvvm.databinding.ActivityMainBinding;
import com.example.zxy.testmvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityTesBinding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTesBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this, activityTesBinding);
        activityTesBinding.setViewModel(mainViewModel);
        CheckBox ck=new CheckBox(this);
        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

    }
}
