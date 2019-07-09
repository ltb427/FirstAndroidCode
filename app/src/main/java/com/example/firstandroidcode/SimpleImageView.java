package com.example.firstandroidcode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
    //bitmap
    private Bitmap mBitmap;

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

    private int measureWidth(int mode, int width)
    {
        switch (mode)
        {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mWidth = width;
                break;
            default:
                break;
        }
        return mWidth;
    }

    private int measureHeight(int mode, int height)
    {
        switch (mode)
        {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mHeight = height;
                break;
            default:
                break;
        }
        return mHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        //获取宽度模式与大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        //获取高度的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //设置view的高度
        setMeasuredDimension(measureWidth(widthMode, width),
                measureHeight(heightMode, height));
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (mBitmap == null)
        {
            mBitmap = Bitmap.createScaledBitmap(ImageUtils.drawableToBitamp(mDrawable),
                    getMeasuredWidth(), getMeasuredHeight(), true);
        }
        //绘制图片
        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        //绘制圆
        mBitmapPaint.setColor(Color.GREEN);
        mBitmapPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getLeft() + 180, getTop() + 160, 30, mBitmapPaint);
    }
}
