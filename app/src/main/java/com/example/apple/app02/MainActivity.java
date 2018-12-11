package com.example.apple.app02;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.hochmuth.com/mp3/Bloch_Prayer.mp3"; // your URL here
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

        initUI();
        initView();
    }




    private void initView() {
        mImage = findViewById(R.id.iv_frontImage);
        mImage.setImageResource(R.drawable.animal);
    }

    private void initUI() {
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                // to first page
                Intent intent1 = new Intent();
                intent1.setClass(getApplicationContext(), FirstActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_2:
                // to second page
                Intent intent2 = new Intent();
                intent2.setClass(getApplicationContext(), SecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_3:
                // to third page
                Intent intent3 = new Intent();
                intent3.setClass(getApplicationContext(), ThirdActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
