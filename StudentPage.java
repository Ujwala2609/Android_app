package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class StudentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);
        LottieAnimationView stuprofile, viewatt;
        stuprofile=findViewById(R.id.stuprofile);
        viewatt=findViewById(R.id.viewatt);
        LottieAnimationView logout1=findViewById(R.id.Logout1);
        stuprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(StudentPage.this, ProfileLogin.class);
                startActivity(it);
            }
        });
        viewatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent it = new Intent(StudentPage.this, StudentAttendanceLogin.class);
                    startActivity(it);
            }
        });
        logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(StudentPage.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}