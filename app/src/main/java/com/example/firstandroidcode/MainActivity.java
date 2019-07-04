package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	public static final String TAG = MainActivity.class.getSimpleName();
	private Button mButton;
	private PopupWindow mPopupWindow;
	private View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.id_add_button);
        mButton.setOnClickListener(this);
        mView = LayoutInflater.from(this).inflate(R.layout.popupwindow_layout, null);
        mView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mPopupWindow.isShowing())
                {
                    mPopupWindow.dismiss();
                }
            }
        });
        mPopupWindow = new PopupWindow(this);
        mPopupWindow.setContentView(mView);
        //消除黑边框
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
    }

    @Override
    public void onClick(View view)
    {
        if (!mPopupWindow.isShowing())
        {
            mPopupWindow.showAsDropDown(view, 0, 0);
        }
    }

}




