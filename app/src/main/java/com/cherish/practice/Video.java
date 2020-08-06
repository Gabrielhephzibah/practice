package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Video extends AppCompatActivity {
    private Button next;
   public VideoView play;
   private Button playing;
   private Button pause;
   SeekBar move;
   MediaPlayer audio;
   SeekBar volumeControl;
   AudioManager audioManager;
//   public void  play(View view){
//       Log.i("info","clicked");
//       play = findViewById(R.id.playvideo);
//       play.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample);
//       MediaController control  = new MediaController(this);
//       control.setAnchorView(play);
//       play.setMediaController(control);
//       play.start();
//
//       MediaPlayer audio = MediaPlayer.create(this, R.raw.drop);
//       audio.start();
//   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        next = findViewById(R.id.nextPage);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(), Listview.class);
                startActivity(next);
            }
        });




        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

//        int maxVolumeMove = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeControl = findViewById(R.id.volume);

//        move.setMax(maxVolumeMove);

        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);


        audio = MediaPlayer.create(Video.this, R.raw.drop);
        play = findViewById(R.id.playvideo);
        play.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample);
        MediaController control  = new MediaController(Video.this);
        control.setAnchorView(play);
        play.setMediaController(control);
//        MediaController control  = new MediaController(this);
//        control.setAnchorView(play);
//        play.setMediaController(control);
//        play.start();

        playing = findViewById(R.id.play);
        playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                play = findViewById(R.id.playvideo);
//                 play.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample);
//                MediaController control  = new MediaController(Video.this);
//                control.setAnchorView(play);
//                play.setMediaController(control);
                 play.start();
//                 audio = MediaPlayer.create(Video.this, R.raw.drop);
                 audio.start();



            }
        });

        pause = findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                play = findViewById(R.id.playvideo);
//                play.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample);
//                MediaController control  = new MediaController(Video.this);
//                control.setAnchorView(play);
//                play.setMediaController(control);
                play.pause();

                audio.pause();
            }
        });

//        volumeControl = findViewById(R.id.volume);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("info", Integer.toString(progress));
//                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        move = findViewById(R.id.scrub);
        move.setMax(audio.getDuration());
        move.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()

        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("info", Integer.toString(progress));
                audio.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                move.setProgress(audio.getCurrentPosition());

            }
        },0,1000);

//
    }
}
