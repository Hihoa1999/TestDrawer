package com.example.testdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Tao 1 databse
    
    public DatabaseHelper(@Nullable Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    //Tao bang trong database
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table user(email text primary key,password text)");
        sqLiteDatabase.execSQL("Create table IF NOT exists tbsv(id integer primary key autoincrement," +

                "name text," +
                "birth text," +
                "school text," +
                "sex integer," +
                "favorite text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
        sqLiteDatabase.execSQL("drop table if exists tbsv");
    }
    //insertting database
    public boolean insert(String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public boolean insertsv(String name,String birth,String school,int sex,String favorite )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("birth",birth);
        contentValues.put("school",school);
        contentValues.put("sex",sex);
        contentValues.put("favorite",favorite);
        long ins1=db.insert("tbsv",null,contentValues);
        if(ins1==-1)return false;
        else return true;
    }

    //checkking if email exists
    public boolean chkemail(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //checking email and password
    public boolean emailpassword(String email,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;

    }
}