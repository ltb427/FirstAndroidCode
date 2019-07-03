package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    public static final String TAG = MainActivity.class.getSimpleName();

    private Button mAddBtn;
    private ItemAdapter mItemAdapter;
	List<ItemBean> mItemList = new ArrayList<>();
	private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = findViewById(R.id.id_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mItemAdapter = new ItemAdapter(mItemList);
        mRecyclerView.setAdapter(mItemAdapter);
        mAddBtn = findViewById(R.id.id_add_btn);
        mAddBtn.setOnClickListener(this);
    }


    private void initData()
    {
        for (int i = 0; i < 2; ++i)
        {
            ItemBean itemBean = new ItemBean(R.drawable.apple_pic, "Apple");
            mItemList.add(itemBean);
            ItemBean banana = new ItemBean(R.drawable.banana_pic, "Banana");
            mItemList.add(banana);
            ItemBean orange = new ItemBean(R.drawable.orange_pic, "Orange");
            mItemList.add(orange);
            ItemBean watermelon = new ItemBean(R.drawable.watermelon_pic, "Watermelon");
            mItemList.add(watermelon);
            ItemBean pear = new ItemBean(R.drawable.pear_pic, "Pear");
            mItemList.add(pear);
            ItemBean grape = new ItemBean(R.drawable.grape_pic, "Grape");
            mItemList.add(grape);
            ItemBean pineapple = new ItemBean(R.drawable.pineapple_pic, "PineApple");
            mItemList.add(pineapple);
            ItemBean strawberry = new ItemBean(R.drawable.strawberry_pic, "StrawBerry");
            mItemList.add(strawberry);
            ItemBean mango = new ItemBean(R.drawable.mango_pic, "Mango");
            mItemList.add(mango);
        }
    }

    @Override
    public void onClick(View view)
    {
        mItemList.add( new ItemBean(R.drawable.strawberry_pic, "StrawBerry"));
        mItemAdapter.notifyDataSetChanged();
        mRecyclerView.scrollToPosition(mItemList.size()-1);
    }
}
