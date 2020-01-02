package com.iauto.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.iauto.test.R;
import com.iauto.test.activity.Base.BaseActivity;
import com.iauto.test.databinding.TimeViewBinding;
import com.iauto.test.viewmodel.TimeViewViewModel;

public class TimeView extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimeViewViewModel vm = ViewModelProviders.of(this).get(TimeViewViewModel.class);
        TimeViewBinding data = DataBindingUtil.setContentView(this, R.layout.time_view);
        data.setLifecycleOwner(this);
        data.setVm(vm);

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        final ProgressBar progressBar = findViewById(R.id.progress_bar);
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });
//            }
//        },1000);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "TimeView: onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "TimeView: onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "TimeView: onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "TimeView: onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "TimeView: onDestroy: ");
        super.onDestroy();
    }

    public void onClick(View v){
        Log.d(TAG, "TimeView: onClick: onclick");
        ((ImageButton)v).setImageResource(R.drawable.earth);
    }

    public void toSecondActivity(View v){
        Log.d(TAG, "TimeView: toSecondActivity: ");

        handler.post(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
//                Intent intent = new Intent("com.example.activity.ACTION_START");
                startActivity(intent);
            }
        });
    }

    public void back(View v){
        Log.d(TAG, "TimeView: back: ");
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello MainActivity");
        setResult(RESULT_OK,intent);
        this.finish();
    }

}
