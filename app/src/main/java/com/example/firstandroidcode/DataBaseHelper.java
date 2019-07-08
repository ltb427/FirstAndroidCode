package com.example.firstandroidcode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper
{
    //路径
    public static final String DATABASE_PATH = Environment.getExternalStorageDirectory() + "/user"+"/user.db";

    //定义数据库的版本号，当数据库需要升级时进行更改
    public static final int DATABASE_VERSION = 2;

    //创建DetailDataOpenHelper实例
    private static DataBaseHelper instance;

    public static DataBaseHelper getInstance(Context mContext)
    {
        if (instance == null)
        {
            synchronized (UserBean.class)
            {
                if (instance == null)
                {
                    instance = new DataBaseHelper(mContext);
                }
            }
        }
        return instance;
    }

    private DataBaseHelper(Context context)
    {
        super(context, DATABASE_PATH, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource)
    {
        try
        {
            TableUtils.createTable(connectionSource, UserBean.class);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
        Log.d("YUKAI", "oldVersion: "+oldVersion+"\n"+"newVersion: "+newVersion);
        try
        {
            TableUtils.dropTable(connectionSource, UserBean.class, false);
            TableUtils.createTable(connectionSource, UserBean.class);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
