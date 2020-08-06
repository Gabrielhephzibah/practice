package com.cherish.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {
    ListView list;
    private  Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),Timers.class);
                startActivity(back);
            }
        });
//        list = findViewById(R.id.List);
//        final ArrayList<String>myFamily = new ArrayList<String>();
//        myFamily.add("Miracle");
//        myFamily.add("Phoebe");
//        myFamily.add("Mathias");
//        myFamily.add("Theophiolus");
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamily);
//        list.setAdapter(arrayAdapter);
//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                view.setVisibility(view.GONE);
//                Log.i("person clicked on", myFamily.get(position));
//            }
//        });

        list= findViewById(R.id.List);
        final ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("Romoke");
        myFriends.add("Cynthia");
        myFriends.add("Adeleke");
        myFriends.add("Boss");
        myFriends.add("Cherish");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, myFriends);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"I clicked on " + myFriends.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}
