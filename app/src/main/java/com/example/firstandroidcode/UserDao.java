package com.example.firstandroidcode;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao
{
    private Dao<UserBean, Integer> childDao;
    private DataBaseHelper helper;

    public UserDao(Context contex)
    {
        helper = DataBaseHelper.getInstance(contex);
        try
        {
            childDao = helper.getDao(UserBean.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 增
     * @param child
     */
    public void addChild(UserBean child) {
        try
        {
            Log.d("YUKAI", child.getName());
            int i = childDao.create(child);
            Log.d("YUKAI", "result: "+i);
        }
        catch (SQLException e)
        {
            Log.d("YUKAI", "error:"+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 删（通过实体）
     * @param child
     */
    public void delChild(UserBean child)
    {
        try
        {
            childDao.delete(child);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 删（通过id）
     * @param id
     */
    public void delChildById(Integer id)
    {
        try
        {
            childDao.deleteById(id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 改
     * @param child
     */
    public void updateChild(UserBean child)
    {
        try
        {
            childDao.update(child);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 查
     * @return
     */
    public List<UserBean> queryAllChild()
    {
        ArrayList<UserBean> childs = null;
        try
        {
            childs = (ArrayList<UserBean>) childDao.queryForAll();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return childs;
    }
}
