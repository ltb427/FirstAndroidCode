package com.example.firstandroidcode;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    //启动服务
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(MainActivity.TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    //销毁服务
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG, "onDestroy");
    }

    //创建服务
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(MainActivity.TAG, "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
