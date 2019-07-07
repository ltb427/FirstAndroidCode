package com.example.firstandroidcode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 绘制
 */
public class ToastHelp
{
    /**
     *context
     */
    private Context mContext;

    /**
     * 圆角半径
     */
    private int mRoundRadius;

    /**
     * 颜色
     */
    private int mColor;

    /**
     * 画刷
     */
    private Paint mPaint;

    /**
     * 文本
     */
    private String mText;

    /**
     * 文本颜色
     */
    private int mTextColor;

    /**
     * 圆角位置
     */
    private int mRoundPoint;

    /**
     * 显示时间
     */
    private int mDisplayTime;

    /**
     * 位图
     */
    private Drawable mDrawable;

    /**
     * 图片的宽度
     */
    private int mImageWidth;

    /**
     * 图片的高度
     */
    private int mImageHeight;

    /**
     * 绘制路径
     */
    private Path mPath;

    /**
     * view
     */
    private View mView;

    /**
     *四个圆角角度
     */
    private float mRadii[];

    /**
     * ToastHelp
     * @param context context
     */
    public ToastHelp(View view, Context context, AttributeSet attrs, int defStyleAttr)
    {
        Log.d("YUKAI", "HAOREN");
        this.mContext = context;
        mView = view;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPath = new Path();
        initAttrs(attrs, defStyleAttr);
        mRadii = new float[8];
    }

    public void draw(Canvas canvas)
    {
        getRadii();
        mPath.addRoundRect(new RectF(0, 0, mView.getRight() - mView.getLeft(),
                mView.getBottom() - mView.getTop()), mRadii, Path.Direction.CW);
        mPaint.setStyle(Paint.Style.FILL);
        //绘制view
        mPaint.setColor(mColor);
        canvas.drawPath(mPath, mPaint);
        //绘制图片

        //绘制文字
    }


    /**
     *  measureWidth
     * @param mode mode
     * @param width width
     * @return int
     */
    public int measureWidth(int mode, int width)
    {
        switch (mode)
        {
            case View.MeasureSpec.UNSPECIFIED:
            case View.MeasureSpec.AT_MOST:
                break;
            case View.MeasureSpec.EXACTLY:
                mImageWidth = width;
                break;
            default:
                break;
        }
        return mImageWidth;
    }

    /**
     * measureHeight
     * @param mode mode
     * @param height height
     * @return int
     */
    public int measureHeight(int mode, int height)
    {
        switch (mode)
        {
            case View.MeasureSpec.UNSPECIFIED:
            case View.MeasureSpec.AT_MOST:
                break;
            case View.MeasureSpec.EXACTLY:
                mImageHeight = height;
                break;
            default:
                break;
        }
        return mImageHeight;
    }

    /**
     * 获取四个圆角角度
     */
    private void getRadii()
    {
        switch (mRoundPoint)
        {
            case 0x01://左上
                mRadii[0] = mRoundRadius;
                mRadii[1] = mRoundRadius;
                mRadii[2] = 0;
                mRadii[3] = 0;
                mRadii[4] = 0;
                mRadii[5] = 0;
                mRadii[6] = 0;
                mRadii[7] = 0;
                break;
            case 0x02: //左下
                mRadii[0] = 0;
                mRadii[1] = 0;
                mRadii[2] = 0;
                mRadii[3] = 0;
                mRadii[4] = 0;
                mRadii[5] = 0;
                mRadii[6] = mRoundRadius;
                mRadii[7] = mRoundRadius;
                break;
            case 0x04: //右上
                mRadii[0] = 0;
                mRadii[1] = 0;
                mRadii[2] = mRoundRadius;
                mRadii[3] = mRoundRadius;
                mRadii[4] = 0;
                mRadii[5] = 0;
                mRadii[6] = 0;
                mRadii[7] = 0;
                break;
            case 0x08://右下
                mRadii[0] = 0;
                mRadii[1] = 0;
                mRadii[2] = 0;
                mRadii[3] = 0;
                mRadii[4] = mRoundRadius;
                mRadii[5] = mRoundRadius;
                mRadii[6] = 0;
                mRadii[7] = 0;
                break;
            case 0x16://全部
                mRadii[0] = mRoundRadius;
                mRadii[1] = mRoundRadius;
                mRadii[2] = mRoundRadius;
                mRadii[3] = mRoundRadius;
                mRadii[4] = mRoundRadius;
                mRadii[5] = mRoundRadius;
                mRadii[6] = mRoundRadius;
                mRadii[7] = mRoundRadius;
                break;
            case 0x03://左上|左下
                mRadii[0] = mRoundRadius;
                mRadii[1] = mRoundRadius;
                mRadii[2] = 0;
                mRadii[3] = 0;
                mRadii[4] = 0;
                mRadii[5] = 0;
                mRadii[6] = mRoundRadius;
                mRadii[7] = mRoundRadius;
                break;
            case 0x05://左上|右上
                mRadii[0] = mRoundRadius;
                mRadii[1] = mRoundRadius;
                mRadii[2] = mRoundRadius;
                mRadii[3] = mRoundRadius;
                mRadii[4] = 0;
                mRadii[5] = 0;
                mRadii[6] = 0;
                mRadii[7] = 0;
                break;
            case 0x09://左上|右下
                mRadii[0] = mRoundRadius;
                mRadii[1] = mRoundRadius;
                mRadii[2] = 0;
                mRadii[3] = 0;
                mRadii[4] = mRoundRadius;
                mRadii[5] = mRoundRadius;
                mRadii[6] = 0;
                mRadii[7] = 0;
                break;
            case 0x0c://左上|右下
                mRadii[0] = 0;
                mRadii[1] = 0;
                mRadii[2] = mRoundRadius;
                mRadii[3] = mRoundRadius;
                mRadii[4] = mRoundRadius;
                mRadii[5] = mRoundRadius;
                mRadii[6] = 0;
                mRadii[7] = 0;
                break;
            case 0x06://左下|右上
                mRadii[0] = 0;
                mRadii[1] = 0;
                mRadii[2] = mRoundRadius;
                mRadii[3] = mRoundRadius;
                mRadii[4] = 0;
                mRadii[5] = 0;
                mRadii[6] = mRoundRadius;
                mRadii[7] = mRoundRadius;
                break;
            case 0x0a://左下|右下
                mRadii[0] = 0;
                mRadii[1] = 0;
                mRadii[2] = 0;
                mRadii[3] = 0;
                mRadii[4] = mRoundRadius;
                mRadii[5] = mRoundRadius;
                mRadii[6] = mRoundRadius;
                mRadii[7] = mRoundRadius;
                break;
                default:
                    break;
        }
    }

    /**
     * initAttrs
     * @param attrs attrs
     */
    private void initAttrs(AttributeSet attrs, int defStyleAttr)
    {
        if (attrs != null)
        {
            TypedArray ta = null;
            try
            {
                ta = mContext.obtainStyledAttributes(attrs, R.styleable.ToastView, defStyleAttr, 0);
                //获取文本
                mText = ta.getString(R.styleable.ToastView_text);
                //获取颜色
                mColor = ta.getColor(R.styleable.ToastView_color, Color.GRAY);
                //获取文本颜色
                mTextColor = ta.getColor(R.styleable.ToastView_textColor, Color.BLACK);
                //获取圆角半径
                mRoundRadius = ta.getDimensionPixelSize(R.styleable.ToastView_circleRadius, 0);
                //获取圆角位置
                mRoundPoint = ta.getInt(R.styleable.ToastView_radius, 0X20);
                //获取显示时间 500ms
                mDisplayTime = ta.getInt(R.styleable.ToastView_timer, 500);
                //获取位图
                mDrawable = ta.getDrawable(R.styleable.ToastView_src);
                //获取图片的宽度
                mImageWidth = ta.getDimensionPixelSize(R.styleable.ToastView_imageWidth, 50);
                //获取图片的高度
                mImageHeight = ta.getDimensionPixelSize(R.styleable.ToastView_imageHeight, 50);
            }
            finally
            {
                if (ta != null)
                {
                    ta.recycle();
                }
            }
        }
    }

    ///////////////公共接口部分//////////////////////

    public Path getPath()
    {
        return mPath;
    }

    public synchronized void setPath(Path mPath)
    {
        this.mPath = mPath;
        mView.invalidate();
    }

    /**
     * getContext
     * @return Context
     */
    public Context getContext()
    {
        return mContext;
    }

    /**
     * setContext
     * @param mContext mContext
     */
    public void setContext(Context mContext)
    {
        this.mContext = mContext;
    }

    /**
     * getRoundRadius
     * @return int
     */
    public int getRoundRadius()
    {
        return mRoundRadius;
    }

    /**
     *  setRoundRadius
     * @param mRoundRadius int
     */
    public synchronized void setRoundRadius(int mRoundRadius)
    {
        this.mRoundRadius = mRoundRadius;
        mView.invalidate();
    }

    /**
     * getColor
     * @return int
     */
    public int getColor()
    {
        return mColor;
    }

    /**
     * setColor
     * @param mColor mColor
     */
    public synchronized void setColor(int mColor)
    {
        this.mColor = mColor;
        mView.invalidate();
    }

    /**
     * getPaint
     * @return Paint
     */
    public Paint getPaint()
    {
        return mPaint;
    }

    /**
     * setPaint
     * @param mPaint mPaint
     */
    public synchronized void setPaint(Paint mPaint)
    {
        this.mPaint = mPaint;
        mView.invalidate();
    }

    /**
     * getText
     * @return String
     */
    public String getText()
    {
        return mText;
    }

    /**
     * setText
     * @param mText mText
     */
    public synchronized void setText(String mText)
    {
        this.mText = mText;
        mView.invalidate();
    }

    /**
     * getTextColor
     * @return int
     */
    public int getTextColor()
    {
        return mTextColor;
    }

    /**
     * setTextColor
     * @param mTextColor mTextColor
     */
    public synchronized void setTextColor(int mTextColor)
    {
        this.mTextColor = mTextColor;
        mView.invalidate();
    }

    /**
     * getRoundPoint
     * @return int
     */
    public int getRoundPoint()
    {
        return mRoundPoint;
    }

    /**
     * setRoundPoint
     * @param mRoundPoint mRoundPoint
     */
    public synchronized void setRoundPoint(int mRoundPoint)
    {
        this.mRoundPoint = mRoundPoint;
        mView.invalidate();
    }

    /**
     * getDisplayTime
     * @return int
     */
    public int getDisplayTime()
    {
        return mDisplayTime;
    }

    /**
     * setDisplayTime
     * @param mDisplayTime mDisplayTime
     */
    public synchronized void setDisplayTime(int mDisplayTime)
    {
        this.mDisplayTime = mDisplayTime;
        mView.invalidate();
    }

    /**
     * getDrawable
     * @return Drawable
     */
    public Drawable getDrawable()
    {
        return mDrawable;
    }

    /**
     * setDrawable
     * @param mDrawable Drawable
     */
    public synchronized void setDrawable(Drawable mDrawable)
    {
        this.mDrawable = mDrawable;
        mView.invalidate();
    }

    /**
     * getImageWidth
     * @return int
     */
    public int getImageWidth()
    {
        return mImageWidth;
    }

    /**
     * setImageWidth
     * @param mImageWidth mImageWidth
     */
    public synchronized void setImageWidth(int mImageWidth)
    {
        this.mImageWidth = mImageWidth;
        mView.invalidate();
    }

    /**
     * getImageHeight
     * @return int
     */
    public int getImageHeight()
    {
        return mImageHeight;
    }

    /**
     * setImageHeight
     * @param mImageHeight int
     */
    public synchronized void setImageHeight(int mImageHeight)
    {
        this.mImageHeight = mImageHeight;
        mView.invalidate();
    }
}
