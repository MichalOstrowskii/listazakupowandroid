package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> nazwa, ilosc;
    DatabaseHelper baza;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baza = new DatabaseHelper(this);
        nazwa = new ArrayList<>();
        ilosc = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(this, nazwa, ilosc);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    }

    private void displayData() {
        Cursor cursor = baza.getData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(MainActivity.this, "Blad!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                nazwa.add(cursor.getString(1));
                ilosc.add(cursor.getString(2));
            }
        }
    }

    public void dodaj(View v)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void usunIntent(View v)
    {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}