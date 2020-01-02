package com.iauto.test.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class DataRepository {
    private String TAG = "TestApp";
    private MutableLiveData<String> info = new MutableLiveData<>();
    private MutableLiveData<String> profile = new MutableLiveData<>();
    private static DataRepository instance = new DataRepository();
    private MutableLiveData<Boolean> flag = new MutableLiveData();

    private DataRepository(){
        flag.setValue(false);
        info.setValue("abc");
        profile.setValue("@drawable/radio");
        info.observeForever(new ProfileObserve());
//        info.observe();
    }

    public static DataRepository getInstance(){
        if (null == instance){
            instance = new DataRepository();
        }
        return instance;
    }

    public MutableLiveData<String> getInfo() {
        return info;
    }

    public MutableLiveData<String> getProfile() {
        return profile;
    }
    public void abcDisplay(){
        Log.d(TAG, "MainActivityViewModel: abcDisplay: "+flag.getValue());
        if (flag.getValue()){
            info.setValue("abc");
            flag.setValue(false);
        }else {
            info.setValue("xyz");
            flag.setValue(true);
        }
    }
    private class ProfileObserve implements Observer<String>{

        /**
         * Called when the data is changed.
         *
         * @param o The new data
         */
        @Override
        public void onChanged(String o) {
            if (info.getValue().equals("abc")){
                profile.setValue("@drawable/radio");
            }else {
                profile.setValue("@drawable/earth");
            }
        }
    }
}
