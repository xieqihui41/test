package com.iauto.uibase;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.iauto.test.R;

public class TitleLayout extends LinearLayout {
    private String TAG = "UIBASE";
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button back = findViewById(R.id.buttonBack);
        Button edit = findViewById(R.id.buttonEdit);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "TitleLayout: onClick: ");
                ((Activity)getContext()).finish();
            }
        });
        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "TitleLayout: onClick: ");
                ((Activity)getContext()).finish();
            }
        });
    }
}
