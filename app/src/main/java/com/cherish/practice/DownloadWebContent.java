package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadWebContent extends AppCompatActivity {
    Button nextPage;
    public  class DownloadTask extends AsyncTask<String, Void , String>{

        @Override
        protected String doInBackground(String... urls) {
//
//            Log.i("URL", strings[0]);
            String result = "";
            URL url ;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1){
                    char current = (char) data;
                    result += current;
                   data = reader.read();
                }
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return "Failed";
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_web_content);
        nextPage = findViewById(R.id.nextPage);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(), DownloadImage.class);
                startActivity(next);
            }
        });
//        DownloadTask download = new DownloadTask();
//        String result = null;
//        try {
//          result = download.execute("https://zappycode.com").get();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Log.i("result", result);
    }
}
