package com.example.firstandroidcode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	public static final String TAG = MainActivity.class.getSimpleName();
	Button btn;
	TextView textView;
	EditText editText;
	ImageView imageView;
	ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.id_btn);
        textView = findViewById(R.id.id_text);
        editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.image_view);
        progressBar = findViewById(R.id.progress_bar);
        imageView.setOnClickListener(this);
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
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("this is a dialog");
                dialog.setMessage("something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(MainActivity.this, "ok",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(MainActivity.this, "cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
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
            case R.id.image_view:
                imageView.setImageResource(R.drawable.banana_pic);
                break;
            default:
                break;
        }
    }
}
