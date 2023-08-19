package com.example.helping_inocentbird_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView bird,enemy1,enemy2,enemy3,coin,volume;
    private AppCompatButton btnstart;
    private Animation animation;

    private MediaPlayer mediaPlayer;
    boolean status =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bird=findViewById(R.id.bird);
        enemy1=findViewById(R.id.enemey1);
        enemy2=findViewById(R.id.enemy2);
        enemy3=findViewById(R.id.enemy3);
        coin=findViewById(R.id.coin);
        volume=findViewById(R.id.volume);
        btnstart=findViewById(R.id.btnstart);

        animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scaleanimation);
        bird.setAnimation(animation);
        enemy1.setAnimation(animation);
        enemy2.setAnimation(animation);
        enemy3.setAnimation(animation);
        coin.setAnimation(animation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer =MediaPlayer.create(MainActivity.this,R.raw.music);
        mediaPlayer.start();

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!status)
                {
                    mediaPlayer.setVolume(0,0);
                    volume.setImageResource(R.drawable.baseline_volume_off_24);
                    status=true;
                }

                else {
                    mediaPlayer.setVolume(1,1);
                    volume.setImageResource(R.drawable.baseline_volume_up_24);
                    status=false;
                }
            }
        });
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                volume.setImageResource(R.drawable.baseline_volume_up_24);
                Intent intent =new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
    }
}