package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class TeacherPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_page);
        LottieAnimationView viewStudent,viewAttendance,takeattendance;
        viewStudent=findViewById(R.id.viewStudent);
        viewAttendance=findViewById(R.id.Attendance);
        takeattendance=findViewById(R.id.takeattendance);
        viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(TeacherPage.this,ViewStudent2.class);
                String p=getIntent().getStringExtra("S");
                it.putExtra("L",p);
                startActivity(it);
            }
        });
        viewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(TeacherPage.this,ViewAttendance2.class);
                String o=getIntent().getStringExtra("S");
                it.putExtra("L",o);
                startActivity(it);
            }
        });

        takeattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(TeacherPage.this,takeAttendance.class);
                startActivity(it);
            }
        });
        LottieAnimationView logout=findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(TeacherPage.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}