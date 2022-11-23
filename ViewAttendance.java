package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);
        TextInputEditText start_date,end_date,stu_name;
        start_date=findViewById(R.id.start_date);
        end_date=findViewById(R.id.end_date);
        stu_name=findViewById(R.id.student_name);
        LottieAnimationView view=findViewById(R.id.view_attendance);
        DatabaseHelper db=new DatabaseHelper(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] tex = {stu_name.getText().toString() + " was present on the following dates\n"};
                try {
                    Date start, end;
                    start = new SimpleDateFormat("dd/MM/yyyy").parse(start_date.getText().toString());
                    end = new SimpleDateFormat("dd/MM/yyyy").parse(end_date.getText().toString());
                    Cursor atten = db.viewAttendance();
                    while (atten.moveToNext()) {
                        Date cursor_date = new SimpleDateFormat("dd/MM/yyyy").parse(atten.getString(1));
                        if (atten.getString(0).equals(stu_name.getText().toString()) && cursor_date.after(start) && cursor_date.before(end)) {
                            tex[0] = tex[0] + atten.getString(1);
                        }
                    }
                     Intent act=new Intent(ViewAttendance.this,admin_attendance_list.class);
                    String h=tex[0];
                    act.putExtra("list_x",h);
                    startActivity(act);
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "Encountered Invalid Date Entry", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}