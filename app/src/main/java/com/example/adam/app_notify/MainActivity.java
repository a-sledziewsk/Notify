package com.example.adam.app_notify;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver mbr = new MyBroadcastReceiver();
    public static final String myIntent = "com.example.adam.mini_projekt_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(myIntent);
        intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY-1);
        registerReceiver(mbr, intentFilter,"com.example.adam.mini_projekt_1.permission.MY_PERMISSION", null);
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        IntentFilter intentFilter = new IntentFilter(myIntent);
//        intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY-1);
//        registerReceiver(mbr, intentFilter, "com.example.adam.mini_projekt_1.permission.MY_PERMISSION", null);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mbr);
    }

}
