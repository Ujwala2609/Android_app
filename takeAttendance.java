package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class takeAttendance extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);
        EditText name = (EditText) findViewById(R.id.name);
        EditText dob = (EditText) findViewById(R.id.dob);
        Button insert = findViewById(R.id.btnInsert);
        DatabaseHelper DB=new DatabaseHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String dobTXT = dob.getText().toString();

                boolean A = DB.markAttendance(nameTXT, dobTXT);
                if(A==true)
                    Toast.makeText(takeAttendance.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(takeAttendance.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }

        });

    }
}