package com.example.unsungroom;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
*/
public class MainActivity extends AppCompatActivity {
    EditText e1;
    ListView listView;
    Button button1;
    String room_name;
    ProgramAdapter adapter1;
    String name_of_person;
    EditText ee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editText);
        button1 = (Button)findViewById(R.id.button);
        listView = (ListView)findViewById(R.id.listView);
        ArrayList<NPeople> arrayList = new ArrayList<>();
        request_username();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room_name = e1.getText().toString();
                arrayList.add(new NPeople(room_name));
                ProgramAdapter adapter1 = new ProgramAdapter(getBaseContext(),arrayList);
                listView.setAdapter(adapter1);
                /*
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                        Intent intent = new Intent(MainActivity.this, chatroom.class);
                        String s = arrayList.get(i).gettext();
                        String s1 = name_of_person;
                        intent.putExtra("room_name",s);
                        intent.putExtra("user_name", s1);
                        startActivity(intent);
                    }
                });
                 */


            }//
        });
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, chatroom.class);
                String s = arrayList.get(i).gettext();
                String s1 = name_of_person;
                intent.putExtra("room_name",s);
                intent.putExtra("user_name", s1);
                startActivity(intent);
            }
        });
*/

    }

    public void request_username()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your name?");
        ee = new EditText(this);
        builder.setView(ee);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                name_of_person = ee.getText().toString();
            }
        });


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                request_username();
            }
        });
        builder.show();
    }
    public void insert_data(View v)
    {
        Map<String,Object> map = new HashMap<>();
        map.put(e1.getText().toString(), "");
      //  reference.updateChildren(map);
    }
}