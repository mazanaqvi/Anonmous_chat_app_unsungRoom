package com.example.unsungroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
public class MainActivity extends AppCompatActivity {
    EditText e1;
    ListView l;
    Button button1;
    ProgramAdapter adapter1;
    String name;
    EditText ee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editText);
        l = (ListView)findViewById(R.id.listView);
        button1 = (Button)findViewById(R.id.button);
        ArrayList<NPeople> arrayList = new ArrayList<>();
        request_username();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String room_name = e1.getText().toString();
                arrayList.add(new NPeople(room_name));
                ProgramAdapter adapter1 = new ProgramAdapter(getBaseContext(),arrayList);
                l.setAdapter(adapter1);
              //  SimpleAdapter adapter = new SimpleAdapter(getBaseContext(),arrayList);
            }
        });
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
                name = ee.getText().toString();
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