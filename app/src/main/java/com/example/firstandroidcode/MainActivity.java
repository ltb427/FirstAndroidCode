package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	public static final String TAG = MainActivity.class.getSimpleName();
	Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.id_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.id_btn:
                Toast.makeText(MainActivity.this, "You click btn!",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
