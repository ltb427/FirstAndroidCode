package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
    "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mangeo",
    "Apple", "Banana", "Orange", "WaterMElon", "Pear", "Grape",
    "Pineapple", "Strawberry", "Cherry", "Mango"};
	public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
    }
}
