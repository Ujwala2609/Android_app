package com.example.selab_project;
import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context) {
        super(context, "Admin_Data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Admin) {
      Admin.execSQL("create Table teachers(name TEXT primary key,subject TEXT,address TEXT,phone TEXT,email TEXT,gender TEXT,age NUMBER,password TEXT)");
      Admin.execSQL("create Table students(name TEXT primary key,address TEXT,contact TEXT,email TEXT,gender TEXT,dob TEXT,class TEXT,classTeacher TEXT)");
      Admin.execSQL("create Table attendance(name TEXT,date TEXT)");
      Admin.execSQL("create Table LoginCredentials(name TEXT,password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("drop Table if exists teachers");
      sqLiteDatabase.execSQL("drop Table if exists students");
      sqLiteDatabase.execSQL("drop table if exists attendance");
    }
    public Cursor viewAttendance(){
         SQLiteDatabase sq=this.getWritableDatabase();
         Cursor cr=sq.rawQuery("Select*from attendance",null);
         return cr;
    }
    public boolean AddTeacher(String name,String Subject,String address,String phone,String email,String gender,String age,String pass){
        SQLiteDatabase ds=this.getWritableDatabase();
        ContentValues ct=new ContentValues();
        ct.put("name",name);
        ct.put("subject",Subject);
        ct.put("address",address);
        ct.put("phone",phone);
        ct.put("email",email);
        ct.put("gender",gender);
        ct.put("age",age);
        ct.put("password",pass);
        long result=ds.insert("teachers",null,ct);
        return result != -1;
    }
    public boolean AddStudent(String name,String address,String Contact,String Email,String gender,String dob,String Class,String classteacher) {
        SQLiteDatabase ds = this.getWritableDatabase();
        ContentValues ct = new ContentValues();
        ct.put("name", name);
        ct.put("address", address);
        ct.put("contact", Contact);
        ct.put("email", Email);
        ct.put("gender", gender);
        ct.put("dob", dob);
        ct.put("class", Class);
        ct.put("classTeacher", classteacher);
        long result = ds.insert("students",null,ct);
        return result!=-1;
    }
    public Cursor getTeachers(){
        SQLiteDatabase sd=this.getWritableDatabase();
        Cursor csr= sd.rawQuery("Select * from teachers",null);
        return csr;
    }

    public boolean markAttendance(String name,String date){
        SQLiteDatabase sd=this.getWritableDatabase();
        ContentValues cnt=new ContentValues();
        cnt.put("name",name);
        cnt.put("date",date);
        long result=sd.insert("attendance",null,cnt);
        return result!=-1;
    }
    public Cursor getStudents(){
        SQLiteDatabase sd=this.getWritableDatabase();
        Cursor csr=sd.rawQuery("Select*from students",null);
        return csr;
    }
    public Cursor getAttendance() {
        SQLiteDatabase sd = this.getWritableDatabase();
        Cursor csr = sd.rawQuery("Select*from attendance", null);
        return csr;
    }
    public Boolean checkusernamepassword(String name, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from teachers where name = ? and password = ?", new String[] {name,password});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }
}
