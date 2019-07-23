package com.example.firstandroidcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{
	public static final String TAG = MainActivity.class.getSimpleName();
	//回复码
    private static final int PERMISSION_REQUEST_CODE = 10000;
    //权限组
	private String[] mPermissions = new String[]
            {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE
            };
	private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        editText = findViewById(R.id.textView);
    }

    @Override
    protected void onDestroy()
    {
        save(editText.getText().toString());
        super.onDestroy();
    }

    public void save(String text)
    {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try
        {
            fileOutputStream = openFileOutput("YUKAI", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(text);
            Log.d("YUKAI", text);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (bufferedWriter != null)
                {
                    bufferedWriter.close();
                    Log.d("YUKAI", "YES");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    //检查权限
    private void checkPermission()
    {
        boolean isAllGranted = checkPermissionAllGranted(mPermissions);
        if (isAllGranted)
        {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            ActivityCompat.requestPermissions(this, mPermissions, PERMISSION_REQUEST_CODE);
        }
    }
    //判断权限
    private boolean checkPermissionAllGranted(String[] permissions)
    {
        for (String permission : permissions)
        {
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED)
            {
                return true;
            }
        }
        return false;
    }
    //回复权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            //用户同意，执行操作
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
        }
        else
        {
            finish();
        }
    }

}
