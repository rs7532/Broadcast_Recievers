package com.example.broadcastrecievers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView power, headphones, times_headphones;

    @SuppressLint({"MissingInflatedId", "ApplySharedPref"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        power = findViewById(R.id.power_view);
        headphones = findViewById(R.id.headphones_view);
        times_headphones = findViewById(R.id.times_headphones_view);

        SharedPreferences settings = getSharedPreferences("boot_counter", MODE_PRIVATE);

        String power_str = power.getText().toString();
        //power_str.replace('0', (char) (settings.getInt("counter", 0)));
        power_str.substring(power_str.length() - 1);
        power_str.concat(String.valueOf((settings.getInt("counter", 0))));
        power.setText(power_str);

    }
}