package com.conectaestudio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "ConectaE.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "ConectaE.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(email TEXT primary key, password TEXT, nombre TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String nombre, String email, String password) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("email", email);
        contentValues.put("nombre", nombre);
        contentValues.put("password", password);

        long result = myDatabase.insert("users", null, contentValues);

        if (result == -1) return false;
        else return true;
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase myDatabase = getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where email = ?", new String[]{email});

        if (cursor.getCount() > 0) return true;
        else return false;

    }

    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase myDatabase = getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where email = ? and password= ?", new String[]{email, password});

        if (cursor.getCount() > 0) return true;
        else return false;
    }

}
