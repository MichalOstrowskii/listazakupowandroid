package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void dodajdo(View v)
    {
        EditText nazwa = findViewById(R.id.editTextText);
        EditText ilosc = findViewById(R.id.editTextText2);
        String nazwap = nazwa.getText().toString();
        Float iloscp = Float.parseFloat(ilosc.getText().toString());
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nazwa", nazwap);
        values.put("ilosc", iloscp);
        db.insert("lista", null ,values);
        db.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}