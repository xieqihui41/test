package com.iauto.test.tablet.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.iauto.test.R;
import com.iauto.test.activity.Base.BaseActivity;
import com.iauto.test.tablet.activity.fragment.Right;
import com.iauto.test.tablet.activity.fragment.RightLayout;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Main2Activity:onCreate: ");
        setContentView(R.layout.activity_main2);
        replaceFragment(new Right());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Main2Activity: onPause: ");
    }

    public void replaceFragment(View view){
        Log.d(TAG, "Main2Activity: replaceFragment: ");
        replaceFragment(new RightLayout());
    }
    public void replaceFragment(Fragment fragment){
        Log.d(TAG, "Main2Activity: replaceFragment: ");
        FragmentManager fragmentManager = getSupportFragmentManager();   //获取实例
        FragmentTransaction transaction = fragmentManager.beginTransaction(); //开启事务
        transaction.replace(R.id.right_layout,fragment);
        transaction.addToBackStack(null);  //fagment添加进返回栈中
        transaction.commit();   //提及事务
    }
}
