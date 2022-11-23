package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
public class StudentAttendanceLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance_login);
        DatabaseHelper obj = new DatabaseHelper(this);
        try {
            LottieAnimationView submit = findViewById(R.id.submit_button_student_profile);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextInputEditText pass = findViewById(R.id.tttt);
                    String name = pass.getText().toString();
                    Cursor te = obj.getStudents();
                    while (te.moveToNext()) {
                        if (te.getString(0).equals(name)) {
                            Intent it = new Intent(StudentAttendanceLogin.this, ViewStudentAttendance.class);
                            it.putExtra("N", name);
                            startActivity(it);
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
        catch (Exception E){
            Toast.makeText(getApplicationContext(),E.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}