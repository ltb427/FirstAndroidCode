package com.example.firstandroidcode;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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
	UserBean userBean;
	UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        Button btn = findViewById(R.id.btn);
        userDao = new UserDao(this);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                userBean = new UserBean("yukai");
                userDao.addChild(userBean);
                UserBean userBean1 = new UserBean("HHH");
                userDao.addChild(userBean1);
                UserBean userBean2 = new UserBean("HHH2");
                userDao.addChild(userBean2);
                UserBean userBean3 = new UserBean("HHH3");
                userDao.addChild(userBean3);
                UserBean userBean4 = new UserBean("HHH4");
                userDao.addChild(userBean4);
                UserBean userBean5 = new UserBean("HHH5");
                userDao.addChild(userBean5);
            }
        });
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

        }
        else
        {
            finish();
        }
    }

}
