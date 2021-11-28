package com.example.unsungroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class chatroom extends AppCompatActivity {

    String temp_key;
    EditText e1;
    TextView t1;
    private String user_name;
    private String room_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
/*
        e1= (EditText)findViewById(R.id.editText2);
        t1= (TextView)findViewById(R.id.textView);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Intent intent = getIntent();
        String room_name1 = intent.getStringExtra("room_name").toString();
        String user_name1 = intent.getStringExtra("user_name").toString();
        //  user_name = getIntent().getExtras().get("user_name").toString();
        // room_name = getIntent().getExtras().get("room_name").toString();
        t1.setText(room_name1);
        //setTitle(" Room - "+room_name1);

 */
    }
}