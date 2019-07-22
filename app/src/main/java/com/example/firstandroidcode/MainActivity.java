package com.example.firstandroidcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.os.Bundle;

public class MainActivity extends BaseActivity
{
    private IntentFilter intentFilter;
	public static final String TAG = MainActivity.class.getSimpleName();
	private LocalReceiver localReceiver;
	private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button btn = findViewById(R.id.id_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent("YUKAI");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter.addAction("YUKAI");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Toast.makeText(MainActivity.this, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
