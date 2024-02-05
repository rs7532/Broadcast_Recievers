package com.example.broadcastrecievers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.broadcastrecievers.broadcasts.HeadsetReceiver;
import com.example.broadcastrecievers.broadcasts.times_headsetReceiver;

public class MainActivity extends AppCompatActivity {
    private final String CUSTOM_ACTION = "com.example.Broadcastrecievers.broadcasts.times_headsetReceiver";
    TextView power, headphones, times_headphones;
    HeadsetReceiver headsetReceiver;
    times_headsetReceiver times_headsetReceiver;
    private static MainActivity ins;

    @SuppressLint({"MissingInflatedId", "ApplySharedPref", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        power = findViewById(R.id.power_view);
        headphones = findViewById(R.id.headphones_view);
        times_headphones = findViewById(R.id.times_headphones_view);

        SharedPreferences settings = getSharedPreferences("boot_counter", MODE_PRIVATE);

        power.setText("power times: " + settings.getInt("counter", 0));

        ins = this;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    protected void onStart() {
        headsetReceiver = new HeadsetReceiver();
        IntentFilter headsetFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(headsetReceiver, headsetFilter);
        times_headsetReceiver = new times_headsetReceiver();
        IntentFilter customFilter = new IntentFilter(CUSTOM_ACTION);
        registerReceiver(times_headsetReceiver, customFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(headsetReceiver);
        unregisterReceiver(times_headsetReceiver);
        super.onStop();
    }

    public static MainActivity  getInstance(){
        return ins;
    }

    public void updateTheTextView_headphone(final String t) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textV1 = (TextView) findViewById(R.id.headphones_view);
                textV1.setText(t);
            }
        });
    }

    public void updateTheTextView_Timesheadphone(final String t) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textV1 = (TextView) findViewById(R.id.times_headphones_view);
                textV1.setText(t);
            }
        });
    }
}