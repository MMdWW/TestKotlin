package com.example.zxy.testmvvm;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by zxy on 2017/5/18.
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    /**
     * apatch文件
     */
    private static final String APATCH_PATH = "/Dennis.apatch";

    private PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        mPatchManager = new PatchManager(this);
        mPatchManager.init("1.0"); // 版本号

        // 加载 apatch
        mPatchManager.loadPatch();

        //apatch文件的目录
        String patchFileString = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
        File apatchPath = new File(patchFileString);

        if (apatchPath.exists()) {
            Log.i(TAG, "补丁文件存在");
            try {
                //添加apatch文件
                mPatchManager.addPatch(patchFileString);
            } catch (IOException e) {
                Log.i(TAG, "打补丁出错了");
                e.printStackTrace();
            }
        } else {
            Log.i(TAG, "补丁文件不存在");
        }

    }
}