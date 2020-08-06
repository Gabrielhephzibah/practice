package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Timers extends AppCompatActivity {
    private TextView nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timers);
        nextPage = findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),HidingElement.class);
                startActivity(next);
            }
        });
         new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("counting", String.valueOf( millisUntilFinished / 10000.));
            }

            @Override
            public void onFinish() {
                Log.i("finished", "WE are done");

            }

        }.start();
//        final Handler timer = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                Log.i("message", "you just checked in few minutes ago");
//                timer.postDelayed(this, 1000);
//            }
//        };
//        timer.post(run);
    }

}
