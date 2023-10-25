package com.example.videocapture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    Button button;
    private final int VIDEO_CAPTURE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        videoView = (VideoView) findViewById(R.id.videoView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, VIDEO_CAPTURE_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == VIDEO_CAPTURE_CODE) {
            if (resultCode == RESULT_OK) {
                Uri uri = intent.getData();
                videoView.setVideoURI(uri);
                MediaStore.Video.Media.getContentUri("data");
            }
        }
    }

//    @Override
//    protected void onActivityResult(int RequestCode, int ResultCode, Intent data) {
//        super.onActivityResult(RequestCode, ResultCode, data);
//        if (RequestCode == VIDEO_CAPTURE_CODE) {
//            if (ResultCode == RESULT_OK) {
//                Uri uri = data.getData();
//                videoView.setVideoURI(uri);
//                MediaStore.Video.Media.getContentUri("data");
//            }
//        }
//    }
}