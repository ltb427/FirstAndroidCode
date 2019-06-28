package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
    "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
    "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
    "Pineapple", "Strawberry", "Cherry", "Mango"};
	public static final String TAG = MainActivity.class.getSimpleName();
	private List<Fruit> fruitList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item,
                fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
    }
    private void initFruit()
    {
        for (int i=0; i<2; ++i)
        {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit mange = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mange);

        }
    }
}
