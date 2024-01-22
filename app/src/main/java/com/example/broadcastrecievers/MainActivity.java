package com.example.broadcastrecievers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView power, headphones, times_headphones;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        power = findViewById(R.id.power_view);
        headphones = findViewById(R.id.headphones_view);
        times_headphones = findViewById(R.id.times_headphones_view);
        
    }
}