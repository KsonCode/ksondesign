package com.weidu.mall.platform.application;

import android.content.Context;

import com.example.lib_core.appclition.BaseApp;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.weidu.mall.platform.exceptionn.CrashHandler;

public class WdApp extends BaseApp {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
        context = this;
        CrashHandler.getInstance().init(this);//初始化异常捕获机制
    }
}
