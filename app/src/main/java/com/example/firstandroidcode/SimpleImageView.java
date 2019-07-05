package com.example.firstandroidcode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 简单的imageview
 */
public class SimpleImageView extends View
{
    //画笔
    private Paint mBitmapPaint;
    //图片的drawable
    private Drawable mDrawable;
    //view的宽度
    private int mWidth;
    //view的高度
    private int mHeight;

    public SimpleImageView(Context context)
    {
        super(context, null);
    }

    public SimpleImageView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        //根据属性初始化
        initAttrs(attrs);
        mBitmapPaint = new Paint();
        //抗锯齿，非常耗费资源
        mBitmapPaint.setAntiAlias(true);
    }
    private void initAttrs(AttributeSet attrs)
    {
        if (null != attrs)
        {
            TypedArray array = null;
            try
            {
                array = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleImageView);
                //根据图片ID找到drawable
                mDrawable = array.getDrawable(R.styleable.SimpleImageView_src);
                //测量drawable的宽度和高度
                measureDrawable();
            }
            finally
            {
                if (array != null)
                {
                    array.recycle();
                }
            }
        }
    }

    private void measureDrawable()
    {
        if (mDrawable == null)
        {
            throw new RuntimeException("drawable can't is null");
        }
        mWidth = mDrawable.getIntrinsicWidth();
        mHeight = mDrawable.getIntrinsicHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (null == mDrawable)
        {
            return;
        }
        //绘制图片
        canvas.drawBitmap(ImageUtils.drawableToBitamp(mDrawable),
                getLeft(), getTop(), mBitmapPaint);
    }
}
