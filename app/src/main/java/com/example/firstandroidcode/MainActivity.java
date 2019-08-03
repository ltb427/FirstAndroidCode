package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	public static final String TAG = MainActivity.class.getSimpleName();
	private MyDatabaseHelper myDatabaseHelper;
	private Button create_btn;
	private Button add_btn;
	private Button delete_btn;
	private Button query_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"BookStore.db",
                null,2);
        create_btn = findViewById(R.id.create_table);
        create_btn.setOnClickListener(this);
        add_btn = findViewById(R.id.add_data);
        add_btn.setOnClickListener(this);
        delete_btn = findViewById(R.id.delete_data);
        delete_btn.setOnClickListener(this);
        query_btn = findViewById(R.id.query_data);
        query_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.create_table:
                myDatabaseHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                //插入第一条数据
                db.insert("book", null , values);
                values.clear();
                //组装第二条数据
                values.put("name", "Tho Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                //插入第二条数据;
                db.insert("book", null, values);
                values.clear();
                Toast.makeText(this, "Add succeeded", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_data:
                SQLiteDatabase db1 = myDatabaseHelper.getWritableDatabase();
                db1.delete("book", "pages > ?", new String[]{"500"});
                Toast.makeText(this, "Delete succeeded", Toast.LENGTH_SHORT).show();
                break;
            case R.id.query_data:
                SQLiteDatabase db2 = myDatabaseHelper.getWritableDatabase();
                //查询book表中的所有数据
                Cursor cursor = db2.query("book", null, null, null,
                        null, null, null);
                int count  = 0;
                if (cursor.moveToFirst())
                {
                    do
                    {
                        //遍历数据
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "book name is " + name);
                        Log.d(TAG, "book author is " + author);
                        Log.d(TAG, "book pages is " + pages);
                        Log.d(TAG, "book price is " + price);
                        ++count;
                    }while (cursor.moveToNext());
                    Log.d(TAG, "book number is " + count);
                }
                break;
                default:
                    break;
        }
    }
}
