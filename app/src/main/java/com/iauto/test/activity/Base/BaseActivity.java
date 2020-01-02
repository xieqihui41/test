package com.iauto.test.activity.Base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected String TAG = "TestApp";
    protected Thread thread;
    protected Handler handler;

    public static List<Activity> activities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d(TAG, "BaseActivity: onCreate: ");
        super.onCreate(savedInstanceState);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                handler = new Handler(Looper.myLooper());
                Looper.loop();
            }
        },TAG);
        thread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "BaseActivity: onResume: ");
        super.onResume();
        addActivity(this);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "BaseActivity: onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "BaseActivity: onStop: ");
        super.onStop();
        removeActivity(this);
        if (activities.isEmpty()){
            Toast.makeText(this,"程序已经在后台运行",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "BaseActivity: onDestroy: ");
        super.onDestroy();
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public void finishAll(){
        for (Activity activity: activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
