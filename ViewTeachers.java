package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewTeachers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teachers);
        StringBuffer buffer=new StringBuffer();
        DatabaseHelper db=new DatabaseHelper(this);
        Cursor result=db.getTeachers();
        String names="Name\n\n";
        String subjects=" Subject\n\n";
        String emails="Email\n\n";
        String phones="Phone\n\n";
        String genders="Gender\n\n";
        while(result.moveToNext()){
           names=names+result.getString(0)+"\n\n";
           subjects=subjects+"  "+result.getString(1)+"\n\n";
           emails=emails+result.getString(4)+"\n\n";
           phones=phones+result.getString(3)+"\n\n";
           genders=genders+result.getString(5)+"\n\n";
           buffer.append(names);
        }
        if(buffer.capacity()!=0) {
           TextView name=findViewById(R.id.teacher_names);
           TextView subject=findViewById(R.id.teacher_subjects);
           TextView email=findViewById(R.id.teacher_emails);
           TextView phone=findViewById(R.id.teacher_phones);
           TextView gender=findViewById(R.id.teacher_genders);
           name.setText(names);
           subject.setText(subjects);
           email.setText(emails);
           phone.setText(phones);
           gender.setText(genders);
        }
        else{
            Toast.makeText(getApplicationContext(),"No data to view",Toast.LENGTH_SHORT).show();
        }
    }
}