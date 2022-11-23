package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

public class AdminLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        LottieAnimationView submit=findViewById(R.id.submit_button_admin_login);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText user = findViewById(R.id.Username);
                TextInputEditText pass = findViewById(R.id.password);
                String us=user.getText().toString();
                String pa=pass.getText().toString();
                  if(us.equals("admin")&&pa.equals("admin")) {
                      Intent it = new Intent(AdminLogin.this, AdminPage.class);
                      startActivity(it);
                  }
                  else{
                      Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_LONG).show();
                  }
                }
        });
    }
}