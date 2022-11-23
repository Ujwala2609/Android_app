package com.example.selab_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class addStudent extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        TextInputEditText name,address,phone,email,Class,cTeacher,dob;
        name=findViewById(R.id.name_student);
        address=findViewById(R.id.address_student);
        phone=findViewById(R.id.phone_student);
        dob=findViewById(R.id.dob_student);
        Class=findViewById(R.id.class_student);
        cTeacher=findViewById(R.id.teacher_student);
        email=findViewById(R.id.email_student);
        RadioButton male,female;
        male=findViewById(R.id.stud_gen_male);
        female=findViewById(R.id.stud_gen_female);
        final String[] gender = {""};
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gender[0] +="Male";
            }
        });
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gender[0] +="Female";
            }
        });

        LottieAnimationView submit=findViewById(R.id.student_submit);
        DatabaseHelper db=new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean a=db.AddStudent(name.getText().toString(),address.getText().toString(),phone.getText().toString(),email.getText().toString(),gender[0],dob.getText().toString(),Class.getText().toString(),cTeacher.getText().toString());
                if(a){
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}