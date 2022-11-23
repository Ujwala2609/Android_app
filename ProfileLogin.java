package com.example.selab_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

public class ProfileLogin extends AppCompatActivity {
    DatabaseHelper obj=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);
        LottieAnimationView submit=findViewById(R.id.submit_button_student_profile);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    TextInputEditText pass = findViewById(R.id.gggg);
                    String name = pass.getText().toString();
                    Cursor te = obj.getStudents();
                    boolean flag = false;
                    while (te.moveToNext()) {
                        if (te.getString(0).equals(name)) {
                            Intent it = new Intent(ProfileLogin.this, ViewProfile.class);
                            it.putExtra("N", name);
                            flag = true;
                            startActivity(it);
                        }
                    }
                    if (!flag) {
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception E){
                    Toast.makeText(getApplicationContext(), E.toString(), Toast.LENGTH_SHORT).show();
                }
                }
        });
    }
}