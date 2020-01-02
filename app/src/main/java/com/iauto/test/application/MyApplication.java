package com.iauto.test.application;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public Context getInstance(){
        return this;
    }
    //
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };
}
