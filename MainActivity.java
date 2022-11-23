package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LottieAnimationView admin=findViewById(R.id.admin_login_button);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,AdminLogin.class);
                startActivity(it);
            }
        });
        LottieAnimationView teacher=findViewById(R.id.teacher_login_button);
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent it=new Intent(MainActivity.this,TeacherLogin.class);
              startActivity(it);
            }
        });
        LottieAnimationView student=findViewById(R.id.student_login_button);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,StudentLogin.class);
                startActivity(it);
            }
        });
    }
}