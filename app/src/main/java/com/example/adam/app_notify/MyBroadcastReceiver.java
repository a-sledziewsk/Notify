package com.example.adam.app_notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notify = new NotificationHelper(context);

        String productName = intent.getStringExtra("Product name");
        String quantity = intent.getStringExtra("Quantity");
        String price = intent.getStringExtra("Price");

        String msg = "Product name: " + productName + "\t\t\tQuantity: "
                + quantity +"\t\t\tPrice: " + price
                +"$";

        notify.createNotification("New product added!",msg);


    }
}
