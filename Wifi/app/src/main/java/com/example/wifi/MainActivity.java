package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btntOn = (Button) findViewById(R.id.btnOn);
        Button btntOff = (Button) findViewById(R.id.btnOFF);
        btntOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager) getApplication().getSystemService(WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        });
        btntOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager w = (WifiManager) getApplication().getSystemService(WIFI_SERVICE);
                w.setWifiEnabled(false);
            }
        });
    }
}