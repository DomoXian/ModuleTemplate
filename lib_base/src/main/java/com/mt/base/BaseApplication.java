package com.mt.base;

import android.app.Application;

/**
 * Created by xianguo on 6/4/17.
 * application 基类
 */

public class BaseApplication extends Application {
    protected static BaseApplication mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static BaseApplication getApp() {
        return mApp;
    }
}
