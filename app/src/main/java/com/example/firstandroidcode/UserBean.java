package com.example.firstandroidcode;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class UserBean
{
    @DatabaseField(columnName = "id", generatedId = true, unique = true)
    private int id;

    @DatabaseField(columnName = "name", useGetSet = true)
    private String name;

    public UserBean()
    {

    }

    public UserBean(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
