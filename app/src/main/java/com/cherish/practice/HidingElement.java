package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HidingElement extends AppCompatActivity {
    TextView text;
    Button nextPage;
    public  void showtext(View view){

        text.setVisibility(View.VISIBLE);
    }

    public void hidetext(View view){
        text.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiding_element);
        text = findViewById(R.id.text);
        nextPage = findViewById(R.id.nextPage);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(), DownloadWebContent.class);
                startActivity(next);
            }
        });

    }
}
