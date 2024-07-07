package com.example.trytry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "userDAta", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table UserDetails(userID TEXT primary key,name Text,surname Text,password PASSWORD,email Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("Drop Table if exists UserDetails");

    }

    public Boolean insertUserData(String name, String username, String surname, String email, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userID", username);
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("password", password);
        contentValues.put("email", email);
        long result = DB.insert("UserDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails ",null);
        return cursor;
    }
    }

