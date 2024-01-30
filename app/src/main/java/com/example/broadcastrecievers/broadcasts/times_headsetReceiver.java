package com.example.broadcastrecievers.broadcasts;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.broadcastrecievers.MainActivity;

public class times_headsetReceiver extends BroadcastReceiver {

    int counter = 0;
    @SuppressLint("SetTextI18n")
    @Override
    public void onReceive(Context context, Intent intent) {
        int h = intent.getIntExtra("state",0);
        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG) && h == 1){
            counter++;
            if (counter % 5 == 0){
                MainActivity.getInstance().updateTheTextView_Timesheadphone("5 times headphone: " + (int) counter / 5);
            }
        }
    }
}