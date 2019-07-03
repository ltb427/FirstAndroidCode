package com.example.firstandroidcode;

public class ItemBean
{
    private int mResId;
    private String mText;

    public ItemBean(int mResId, String mText)
    {
        this.mResId = mResId;
        this.mText = mText;
    }

    public int getmResId()
    {
        return mResId;
    }

    public void setmResId(int mResId)
    {
        this.mResId = mResId;
    }

    public String getmText()
    {
        return mText;
    }

    public void setmText(String mText)
    {
        this.mText = mText;
    }
}
