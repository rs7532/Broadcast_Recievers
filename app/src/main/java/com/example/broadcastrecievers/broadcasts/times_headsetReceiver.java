package com.example.broadcastrecievers.broadcasts;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.session.PlaybackState;

import com.example.broadcastrecievers.MainActivity;

public class times_headsetReceiver extends BroadcastReceiver {
    private final String CUSTOM_ACTION = "com.example.Broadcastrecievers.broadcasts.times_headsetReceiver";
    int counter;
    @SuppressLint("SetTextI18n")
    @Override
    public void onReceive(Context context, Intent intent) {
        counter = intent.getIntExtra("count", 0);
        if (intent.getAction().equals(CUSTOM_ACTION)){
            MainActivity.getInstance().updateTheTextView_Timesheadphone("5 times headphone: " + counter);
        }
    }
}