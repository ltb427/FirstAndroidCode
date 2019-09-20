package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity
{
	public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = findViewById(R.id.btn_create);
        createDatabase.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LitePal.getDatabase();
            }
        });
    }
}
