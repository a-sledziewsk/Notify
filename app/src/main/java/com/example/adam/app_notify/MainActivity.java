package com.example.adam.app_notify;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver mbr = new MyBroadcastReceiver();
    //public static final String myIntent = "com.example.adam.app_notify";
    private static final String permission = "com.example.adam.mini_projekt_1.permission.MY_PERMISSION";
    public static final String myIntent = "com.example.adam.app_notify.intent.action.EVENT1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationHelper notify = new NotificationHelper(this);
        notify.createNotification("New product added!","GERE");

    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(myIntent);
        intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY-1);
        registerReceiver(mbr, intentFilter, permission, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mbr);
    }

}
