package com.iauto.test.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iauto.test.R;
import com.iauto.test.activity.Base.BaseActivity;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String data = getIntent().getStringExtra("data");
        Log.d(TAG, "onCreate: data"+data);
    }
    public void action1(View view){
        Log.d(TAG, "SecondActivity: action1: ");
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
    public void dialogOpen(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("This is a dialog");
        dialog.setMessage("Something important");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "onClick: Ok: "+which);
            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "onClick: cancel: "+which);
            }
        });
        dialog.show();
    }
}
