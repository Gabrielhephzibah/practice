package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProcessingJSONData extends AppCompatActivity {
    Button next;

    public  void nextPage(View view){
        Log.i("Button Clicked","the next page button is clicked");
        Intent nextPage = new Intent(getApplicationContext(), GettingUserLocation.class);
        startActivity(nextPage);

    }

    public  class DownloadData extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url ;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                 urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data!= -1){
                    char current = (char) data;
                    result += current;
                    data= reader.read();
                }
                return  result;

            }catch (Exception e){
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String weatherInfo = jsonObject.getString("weather");
                Log.i("message",weatherInfo);

                JSONArray arr = new JSONArray(weatherInfo);
                for (int i = 0; i <arr.length(); i++){
                    JSONObject object = arr.getJSONObject(i);
                    Log.i("main",object.getString("main"));
                    Log.i("description", object.getString("description"));

                }

            }catch (Exception e){
                e.printStackTrace();
            }

            Log.i("Json Message", s);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.processing_json_data);
        next = findViewById(R.id.nextBtn);
        DownloadData download = new DownloadData();

        try{

            download.execute("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").get();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
