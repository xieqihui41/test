package com.iauto.test.uibase;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.iauto.test.R;
import com.iauto.test.uibase.def.Fruit;

import java.util.List;

public class FruitAdater extends ArrayAdapter {
    private String TAG = "UIBASE";
    private int resource;
    public FruitAdater(@NonNull Context context, int resource, List<Fruit> objects) {
        super(context, resource,objects);
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //不能调用父类的getView方法
        Log.d(TAG, "getView: ");
        Fruit fruit = (Fruit) getItem(position);
        View view;
        ViewHolder holder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
            holder = new ViewHolder();
            holder.fruitImage = view.findViewById(R.id.fruit_Image);
            holder.fruitName = view.findViewById(R.id.fruit_text);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.fruitImage.setImageResource(fruit.getImage());
        holder.fruitName.setText(fruit.getName());
        return view;
    }
    private class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
