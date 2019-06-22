package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d(MainActivity.TAG, data);
    }

    @Override
    protected void onActivityResult(int requetCode, int resultCode, Intent data)
    {
        switch (requetCode)
        {
            case 1:
                if (RESULT_OK == resultCode)
                {
                    String resultData = data.getStringExtra("data_return");
                    Log.d(MainActivity.TAG, resultData);
                }
                break;
            default:
                break;
        }
    }
}
