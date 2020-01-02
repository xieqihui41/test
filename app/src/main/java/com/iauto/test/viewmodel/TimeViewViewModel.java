package com.iauto.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class TimeViewViewModel extends AndroidViewModel {
    private MutableLiveData profile = new MutableLiveData();
    private MutableLiveData progressBarVisible = new MutableLiveData();
    private MutableLiveData progress = new MutableLiveData();

    public TimeViewViewModel(@NonNull Application application) {
        super(application);
        profile.setValue("@drawable/earth");
        progressBarVisible.setValue("visible");
        progress.setValue("90");
    }
    public MutableLiveData getProfile() {
        return profile;
    }

    public MutableLiveData getProgressBarVisible(){
        return progressBarVisible;
    }
    public MutableLiveData getProgress(){
        return progress;
    }
}
