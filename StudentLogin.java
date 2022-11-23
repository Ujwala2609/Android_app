package com.example.selab_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

public class StudentLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        LottieAnimationView submit=findViewById(R.id.submit_button_student_login2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText user = findViewById(R.id.Username2);
                TextInputEditText pass = findViewById(R.id.password2);
                String us=user.getText().toString();
                String pa=pass.getText().toString();
                if(us.equals("student")&&pa.equals("student")) {
                    Intent it = new Intent(StudentLogin.this, StudentPage.class);
                    startActivity(it);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}