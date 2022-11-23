package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class addTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        TextInputEditText name,contact,email,age,password,address,subject;
        RadioButton Male,Female;
        name=findViewById(R.id.name);
        subject=findViewById(R.id.subject);
        address=findViewById(R.id.address);
        contact=findViewById(R.id.contact);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        Male=findViewById(R.id.male);
        Female=findViewById(R.id.female);
        final String[] gender = {""};
         Male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(Male.isChecked()){
                     gender[0] +="Male";
                 }
             }
         });
        Female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Female.isChecked()){
                    gender[0] +="Female";
                }
            }
        });
        LottieAnimationView submit=findViewById(R.id.submit_add_t);
        DatabaseHelper DB=new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean x=DB.AddTeacher(name.getText().toString(),subject.getText().toString(),address.getText().toString(),contact.getText().toString(),email.getText().toString(), gender[0],age.getText().toString(),password.getText().toString());
                if(x==true) {
                    Toast.makeText(getApplicationContext(), "Teacher Addded", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not added",Toast.LENGTH_SHORT).show();
                }
                }
        });
    }
}