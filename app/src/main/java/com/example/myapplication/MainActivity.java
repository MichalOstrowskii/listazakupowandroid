package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void dodaj(View v)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void odczytaj(View v)
    {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] kolumny = {"id", "nazwa", "ilosc"};
        Cursor cursor = db.query("lista", kolumny, null, null, null, null, null);
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String nazwa = cursor.getString(1);
            Float ilosc = cursor.getFloat(2);
            Log.d("MojaBazaDanych", "Id: "+id+", nazwa: "+nazwa+", ilosc: "+ilosc);
        }
        cursor.close();
        db.close();
    }
    public void usunIntent(View v)
    {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}