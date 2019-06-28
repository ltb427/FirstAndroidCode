package com.example.firstandroidcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>
{
    private int mResourceId;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects)
    {
        super(context, resource, objects);
        mResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(mResourceId, parent,
                false);
        ImageView imageView = (ImageView)view.findViewById(R.id.fruit_image);
        TextView textView = (TextView)view.findViewById(R.id.fruit_text);
        imageView.setImageResource(fruit.getmImageId());
        textView.setText(fruit.getmName());
        return view;
    }
}
