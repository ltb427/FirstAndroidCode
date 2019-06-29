package com.example.firstandroidcode;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout implements View.OnClickListener
{

    public TitleLayout(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button titleBack = findViewById(R.id.title_back);
        Button titleEidt = findViewById(R.id.title_edit);
        titleBack.setOnClickListener(this);
        titleEidt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.title_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "You clicked edit button",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
