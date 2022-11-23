package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

public class TeacherLogin extends AppCompatActivity {
    DatabaseHelper DB=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        LottieAnimationView submit = findViewById(R.id.submit_button_teacher_login1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText user = findViewById(R.id.Username1);
                TextInputEditText pass = findViewById(R.id.password1);
                String us = user.getText().toString();
                String pa = pass.getText().toString();
                if (us.equals("") || pa.equals("")) {
                    Toast.makeText(TeacherLogin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        Boolean checkuserpass = false;
                        Cursor te = DB.getTeachers();
                        while (te.moveToNext()) {
                            if (te.getString(0).equals(us)) {
                                if (te.getString(7).equals(pa)) {
                                    checkuserpass = true;

                                }
                            }
                        }
                        if (checkuserpass == true) {
                            Toast.makeText(getApplicationContext(), "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(TeacherLogin.this, TeacherPage.class);
                            intent.putExtra("S",us);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception E){
                        Toast.makeText(getApplicationContext(), E.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}