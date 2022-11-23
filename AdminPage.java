package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class AdminPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        LottieAnimationView addTeacher,addStudent,viewTeacher,viewStudent,viewAttendance;
        addTeacher=findViewById(R.id.addTeacher);
        addStudent=findViewById(R.id.addStudent);
        viewTeacher=findViewById(R.id.viewTeacher);
        viewStudent=findViewById(R.id.viewStudent);
        viewAttendance=findViewById(R.id.Attendance);
        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this, addTeacher.class);
                startActivity(it);
            }
        });
        viewTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,ViewTeachers.class);
                startActivity(it);
            }
        });
        viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,ViewStudent.class);
                startActivity(it);
            }
        });
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,addStudent.class);
                startActivity(it);
            }
        });
        viewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,ViewAttendance.class);
                startActivity(it);
            }
        });
        LottieAnimationView logout=findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(AdminPage.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}