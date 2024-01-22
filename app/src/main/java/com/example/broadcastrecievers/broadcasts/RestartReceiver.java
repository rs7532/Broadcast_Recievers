package com.example.broadcastrecievers.broadcasts;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

public class RestartReceiver extends BroadcastReceiver {

    @SuppressLint("ApplySharedPref")
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = context.getSharedPreferences("boot_counter", Context.MODE_PRIVATE);
        int counter = settings.getInt("counter", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("counter", counter + 1);
        editor.commit();
        System.out.println("completed!");
    }
}