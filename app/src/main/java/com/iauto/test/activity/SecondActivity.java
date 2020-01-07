package com.iauto.test.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.iauto.test.R;
import com.iauto.test.activity.Base.BaseActivity;
import com.iauto.test.uibase.FruitAdater;
import com.iauto.test.uibase.RecyclerFruit;
import com.iauto.test.uibase.def.Fruit;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends BaseActivity {

    private List<Fruit> fruitsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String data = getIntent().getStringExtra("data");
        Log.d(TAG, "SecondActivity: onCreate: data"+data);
        initFruit();
    }
    private void initFruit(){
        String[] listData = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Pineapple","Strawberry","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Pineapple","Strawberry"};

        for (int i=0; i<listData.length; i++){
            fruitsList.add(new Fruit(listData[i],R.drawable.fruit));
        }
        FruitAdater adater = new FruitAdater(this,R.layout.fruit_item,fruitsList);
        RecyclerFruit recyclerFruit = new RecyclerFruit();
        adater.insert(new Fruit("dudu",R.drawable.fruit),0);
        ListView listView = findViewById(R.id.list_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        listView.setAdapter(adater);
        recyclerView.setAdapter(recyclerFruit);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: position: "+position+" id: "+id);
                parent.setSelection(position);
                Fruit fruit = fruitsList.get(position);
                Toast.makeText(SecondActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
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
