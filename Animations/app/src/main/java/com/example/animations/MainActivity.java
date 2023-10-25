
package com.example.animations;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnzIn;
    private Button btnzOut;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnzIn = (Button) findViewById(R.id.btnZoomIn);
        btnzOut = (Button) findViewById(R.id.btnZoomOut);
        img = (ImageView) findViewById(R.id.imgvw);

        btnzIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                img.startAnimation(clockwise);
            }
        });
        btnzOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation antiClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anticlockwise);
                img.startAnimation(antiClockwise);
            }
        });
    }
}