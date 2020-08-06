package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImage extends AppCompatActivity {
    Button downloadImage;
    ImageView image;
    Button next;
    public  void  download(View view){
        Log.i("image","yeah,downloaded");

        downloader task = new downloader();
        Bitmap myImage;
        try {
            myImage = task.execute("https://images.unsplash.com/photo-1496257849330-09864b929d10?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60").get();
            image.setImageBitmap(myImage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  class  downloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try{

                URL url = new URL(urls[0]);
                HttpURLConnection connection =(HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(in);
                return myBitmap;


            }catch (Exception e){
                e.printStackTrace();
                return null;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);
        downloadImage = findViewById(R.id.downloadImageBtn);
        image = findViewById(R.id.image);
        next = findViewById(R.id.nextPageBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(), ProcessingJSONData.class);
                startActivity(next);
            }
        });



    }
}
