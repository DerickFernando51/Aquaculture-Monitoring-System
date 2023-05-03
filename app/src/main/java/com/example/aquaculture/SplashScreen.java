package com.example.aquaculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int DELAY_TIME = 5000;
        VideoView videoView; //video

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        videoView=findViewById(R.id.viewVideo); //video

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this,MainActivity2.class);
                startActivity(i);
                finish();

            }
        },DELAY_TIME);

        //VIDEO
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.seabed_animation); //set the path of the video that we need to use in our VideoView
        videoView.start();

    }
}