package com.example.firstandroidcode;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.TAG, getClass().getSimpleName());
        ActivityCllector.addActivity(this);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(MainActivity.TAG, getClass().getSimpleName());
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityCllector.removeActivity(this);
    }
    @Override
    public void onBackPressed()
    {
        ActivityCllector.finshiAll();
    }
}
