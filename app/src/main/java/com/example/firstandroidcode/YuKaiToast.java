package com.example.firstandroidcode;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class YuKaiToast
{
    private static Toast mToast;

    public static Toast makeYuKaiText(Context context,int delay)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.toast_view,null);
        if (mToast == null)
        {
            mToast = new Toast(context);
        }
        else
        {
            mToast.cancel();
            mToast = new Toast(context);
        }
        mToast.setView(view);
        mToast.setDuration(delay);
        mToast.setGravity(Gravity.CENTER, 0 , 0);
        return mToast;
    }
}
