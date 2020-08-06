package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean isShowing = true;
    private Button nextPage;

    public  void fade(View view){
        Log.i("info", "image clicked");


        ImageView image = (ImageView) findViewById(R.id.image);
        ImageView image2 = (ImageView)findViewById(R.id.image2);
//        image.animate().scaleXBy(0.5f).setDuration(1000);
//
//        image.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
//        image.animate().rotation(1800).alpha(0).setDuration(1000);
//
//        image.animate().translationYBy(-2000).setDuration(2000);

        if(isShowing){
            isShowing = false;
            image.animate().alpha(0).setDuration(2000);
            image2.animate().alpha(1).setDuration(2000);
        } else {
            isShowing = true;
            image.animate().alpha(1).setDuration(2000);
            image2.animate().alpha(0).setDuration(2000);
        }





    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView)findViewById(R.id.image);
        image.setX(-2000);
        image.animate().translationXBy(2000).rotation(3600).setDuration(2000);

        nextPage = findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),Video.class);
                startActivity(next);
            }
        });
    }
}
