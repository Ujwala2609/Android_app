package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class admin_attendance_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_attendance_list);
        Intent it=getIntent();
        String lis=it.getExtras().getString("list_x");
        TextView tv=findViewById(R.id.att);
        tv.setText(lis);
    }
}