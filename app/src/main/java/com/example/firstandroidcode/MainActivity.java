package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	public static final String TAG = MainActivity.class.getSimpleName();
	Button btn;
	TextView textView;
	EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.id_btn);
        textView = findViewById(R.id.id_text);
        editText = findViewById(R.id.edit_text);
        editText.setOnClickListener(this);
        btn.setOnClickListener(this);
        textView.setOnClickListener(this);
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
            case R.id.id_text:
                TextView tv = (TextView)view;
                Toast.makeText(MainActivity.this, tv.getText(),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_text:
                Toast.makeText(MainActivity.this, editText.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
