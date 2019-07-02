package com.example.firstandroidcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MvpView
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
    //进度条
    ProgressDialog progressDialog;
    TextView text;
    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
    }
    //检查权限
    private void checkPermission()
    {
        boolean isAllGranted = checkPermissionAllGranted(mPermissions);
        if (isAllGranted)
        {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
            text = (TextView)findViewById(R.id.text);

            // 初始化进度条
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("正在加载数据");
            //初始化Presenter
            presenter = new MvpPresenter(this);
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
            text = (TextView)findViewById(R.id.text);

            // 初始化进度条
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("正在加载数据");

            //初始化Presenter
            presenter = new MvpPresenter(this);
        }
        else
        {
            finish();
        }
    }

    // button 点击事件调用方法
    public void getData(View view)
    {
        presenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view)
    {
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view)
    {
        presenter.getData("error");
    }

    @Override
    public void showLoading()
    {
        if (!progressDialog.isShowing())
        {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading()
    {
        if (progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data)
    {
        text.setText(data);
    }

    @Override
    public void showFailureMessage(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }

    @Override
    public void showErrorMessage()
    {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        text.setText("网络请求数据出现异常");
    }
}
