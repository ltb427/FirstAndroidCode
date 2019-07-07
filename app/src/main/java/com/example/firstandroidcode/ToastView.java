package com.example.firstandroidcode;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ToastView extends View
{
    /**
     * mToastHelp
     */
    private ToastHelp mToastHelp;

    /**
     * ToastView
     * @param context context
     */
    public ToastView(Context context)
    {
        this(context, null, 0);
    }

    /**
     *  ToastView
     * @param context context
     * @param attrs attrs
     * @param defStyleAttr defStyleAttr
     */
    public ToastView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mToastHelp = new ToastHelp(this, context, attrs, defStyleAttr);
    }

    /**
     * ToastView
     * @param context Context
     * @param attrs AttributeSet
     * @param defStyleAttr int
     * @param defStyleRes  int
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ToastView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * ToastView
     * @param context Context
     * @param attrs AttributeSet
     */
    public ToastView(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mToastHelp.measureWidth(widthmode, width),
                mToastHelp.measureHeight(heightmode, height));
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
       mToastHelp.draw(canvas);
    }
}
