package com.iauto.test.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.iauto.test.repository.DataRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private String TAG = "TestApp";
    private MutableLiveData<String> info = DataRepository.getInstance().getInfo();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "MainActivityViewModel: create");
    }

    public MutableLiveData<String> getInfo(){
        return info;
    }

    public void abcDisplay(){
        Log.d(TAG, "MainActivityViewModel: abcDisplay: ");
        DataRepository.getInstance().abcDisplay();
    }

}
