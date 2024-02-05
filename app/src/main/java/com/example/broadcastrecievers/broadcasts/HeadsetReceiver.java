package com.example.broadcastrecievers.broadcasts;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

import com.example.broadcastrecievers.MainActivity;

public class HeadsetReceiver extends BroadcastReceiver {
    int counter = 0;
    private final String CUSTOM_ACTION = "com.example.Broadcastrecievers.broadcasts.times_headsetReceiver";
    @SuppressLint("SetTextI18n")
    @Override
    public void onReceive(Context context, Intent intent) {
        int h = intent.getIntExtra("state",0);
        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG) && h == 1){
            counter++;
            MainActivity.getInstance().updateTheTextView_headphone("headphone input times: " + counter);
            if (counter % 5 == 0){
                Intent intent1 = new Intent(CUSTOM_ACTION);
                intent1.putExtra("count", (int) counter / 5);
                context.sendBroadcast(intent1);
            }
        }
    }
}