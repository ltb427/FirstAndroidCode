package com.example.firstandroidcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	public static final String TAG = MainActivity.class.getSimpleName();
	private MyDatabaseHelper myDatabaseHelper;
	private Button create_btn;
	private Button add_data_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(MainActivity.this,"BookStore.db",
                null,2);
        create_btn = findViewById(R.id.create_table);
        create_btn.setOnClickListener(this);
        add_data_btn = findViewById(R.id.add_data);
        add_data_btn.setOnClickListener(this);
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
                default:
                    break;
        }
    }
}
