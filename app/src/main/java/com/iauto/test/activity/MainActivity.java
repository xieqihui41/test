package com.iauto.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.iauto.test.R;
import com.iauto.test.activity.Base.BaseActivity;
import com.iauto.test.databinding.ActivityMainBinding;
import com.iauto.test.viewmodel.MainActivityViewModel;

public class MainActivity extends BaseActivity {

    private MainActivityViewModel vm;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        ActivityMainBinding data = DataBindingUtil.setContentView(this, R.layout.activity_main);
        data.setLifecycleOwner(this);
        data.setVm(vm);
        editText = findViewById(R.id.editText3);

    }
    @Override
    protected void onStart() {
        Log.d(TAG, "MainActivity: onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "MainActivity: onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "MainActivity: onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "MainActivity: onStop: ");
        super.onStop();
    }

    //broadcast a custom intent
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.iauto.test.LAUNCH");
        sendBroadcast(intent);
    }

    public void onClickAddName(View view){
        Log.d(TAG,"MainActivity: onClickAddName:start");
        Intent intent = new Intent();
        intent.setClass(this,TimeView.class);
        //请求吗需要是唯一值
        //startActivityForResult(intent,2);
        startActivity(intent);
        Log.d(TAG,"MainActivity: onClickAddName:end");
    }

    public void onClickRetrieveStudents(View view){
        Log.d(TAG,"onClickRetrieveStudents：start");
        vm.abcDisplay();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("data","come from main activity");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                String text = editText.getText().toString();
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult: ");
        if (resultCode == RESULT_OK){
            String resultStr = data.getStringExtra("data_return");
            Log.d(TAG, "onActivityResult: "+resultStr);
        }
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "MainActivity: onDestroy: ");
        super.onDestroy();
    }
}
