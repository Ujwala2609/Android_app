package com.example.selab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ViewProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        String name="Name\n";
        String phone="Phone\n";
        String email="   Email\n";
        String Class="Class\n";
        String Tname="Teacher\n";
        TextView n,p,e,c,t;
        n=findViewById(R.id.textstu);
        p=findViewById(R.id.textcontact);
        e=findViewById(R.id.textemail);
        c=findViewById(R.id.textclass);
        t=findViewById(R.id.textcteacher);
        String name2=getIntent().getExtras().getString("N");
        DatabaseHelper DB=new DatabaseHelper(this);
        Cursor result=DB.getStudents();
        while(result.moveToNext()){
            if(result.getString(0).equals(name2)) {
                name = name + result.getString(0) + "\n";
                phone = phone + result.getString(2) + "\n";
                email = email + "   " + result.getString(3) + "\n";
                Class = Class + result.getString(6) + "\n";
                Tname = Tname + result.getString(7) + "\n";
            }
        }
        n.setText(name);
        p.setText(phone);
        e.setText(email);
        c.setText(Class);
        t.setText(Tname);
    }
}