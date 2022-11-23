package com.example.selab_project;


import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;


public class ViewAttendance2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance2);
            String name = "Name\n";
            String date = "Date\n";
            TextView n, d;
            n = findViewById(R.id.nameTXT);
            d = findViewById(R.id.dobTXT);
            DatabaseHelper DB = new DatabaseHelper(this);
            Cursor result = DB.viewAttendance();
            String q = getIntent().getStringExtra("S");
            while (result.moveToNext()) {
                name = name + result.getString(0) + "\n";
                date = date + result.getString(1) + "\n";
            }
            n.setText(name);
            d.setText(date);
    }
}