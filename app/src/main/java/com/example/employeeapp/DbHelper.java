package com.example.employeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

   static  String dbname="Employeeapp.db";
   static String tablename="employee";
   static String col1="id";
   static  String col2="empcode";
   static  String col3="name";
   static String col4="designation";
   static  String col5="mobile";
    public DbHelper(Context context) {
        super(context, dbname, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table " +tablename+"("+col1+
                " integer primary key autoincrement,"+col2+
                " text,"+col3+" text,"+col4+" text,"+col5+" text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     String query="drop table if exists "+tablename;
     db.execSQL(query);
     onCreate(db);


    }
    public  boolean insertEmployee(String empcode,String name,String designation, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues Content = new ContentValues();
        Content.put(col2, empcode);
        Content.put(col3, name);
        Content.put(col4, designation);
        Content.put(col5, mobile);
        long status = db.insert(tablename, null, Content);
        if (status == -1) {
            return false;

        } else {
            return true;
        }

    }
 public Cursor searchEmployee(String empcode)
 {
     SQLiteDatabase db=this.getWritableDatabase();
     String query="select * from "+tablename+" where "+col2+"="+"'"+empcode+"'";
     Cursor c=db.rawQuery(query,null);
     return  c;
 }

}



