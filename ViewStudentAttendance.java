package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ViewStudentAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_attendance);
        String date="\n\n\n";
        TextView d;
        d=findViewById(R.id.textdate);
        String name2=getIntent().getExtras().getString("N");
        DatabaseHelper DB=new DatabaseHelper(this);
        Cursor result=DB.viewAttendance();
        while(result.moveToNext()){
            if(result.getString(0).equals(name2)) {
                date = date +"                        "+result.getString(1) + "\n";
            }
        }
        d.setText(date);
    }
}