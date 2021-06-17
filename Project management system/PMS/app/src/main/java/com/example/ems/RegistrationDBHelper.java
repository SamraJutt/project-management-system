package com.example.ems;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegistrationDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName1.db";
    public static final String APPLICANT_TABLE_NAME = "APPLICANT";
    public static final String APPLICANT_COLUMN_ID = "id";
    public static final String APPLICANT_COLUMN_NAME = "name";
    public static final String APPLICANT_OLUMN_PHONE = "phone";
    public static final String APPLICANT_COLUMN_AGE = "age";
    public static final String APPLICANT_COLUMN_PROJECT = "project";
    public static final String APPLICANT_COLUMN_CNIC = "cnic";


    private HashMap hp;

    public RegistrationDBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table PARTICIPENTS" +
                        "(id integer primary key AUTOINCREMENT , name text,sureName text,age text,event text,cnic text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS PARTICIPENT");
        onCreate(db);
    }

    public boolean insertapplicant(String name, String surename, String age, String event, String cnic) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(APPLICANT_COLUMN_AGE, age);
        contentValues.put(APPLICANT_COLUMN_CNIC, cnic);
        contentValues.put(APPLICANT_COLUMN_PROJECT, event);
        contentValues.put(APPLICANT_OLUMN_PHONE, surename);
        contentValues.put(APPLICANT_COLUMN_NAME, name);

        db.insert(APPLICANT_TABLE_NAME, null, contentValues);
        return true;
    }


    public Registration getData(int Id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from PARTICIPENTS where id="+Id, null );
        res.moveToFirst();
        String id = res.getString((res.getColumnIndex("id")));
        String name = res.getString((res.getColumnIndex(APPLICANT_COLUMN_NAME)));
        String sureName = res.getString((res.getColumnIndex(APPLICANT_OLUMN_PHONE)));
        String age = res.getString((res.getColumnIndex(APPLICANT_COLUMN_AGE)));
        String event = res.getString((res.getColumnIndex(APPLICANT_COLUMN_PROJECT)));
        String cnic = res.getString((res.getColumnIndex(APPLICANT_COLUMN_CNIC)));

        // craeting Event oject to store the info. reterieved from database
        Registration registration = new Registration(id , name, sureName ,  event , age, cnic);
        return registration;
    }

/*
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }
*/

    public Integer deleteApplicant(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("APPLICANT",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public boolean updateParticipent (Integer id, String name, String surename,String age,String event,String cnic) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(APPLICANT_COLUMN_AGE, age);
        contentValues.put(APPLICANT_COLUMN_CNIC, cnic);
        contentValues.put(APPLICANT_COLUMN_PROJECT, event);
        contentValues.put(APPLICANT_OLUMN_PHONE, surename);
        contentValues.put(APPLICANT_COLUMN_NAME, name);
        db.update("APPLICANT", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public List<Registration> getAllApplicants() {
        //ArrayList<String> array_list = new ArrayList<String>();
        List<Registration> registrationList = new ArrayList<>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from PARTICIPENTS", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            String id = res.getString((res.getColumnIndex("id")));
            String name = res.getString((res.getColumnIndex(APPLICANT_COLUMN_NAME)));
            String sureName = res.getString((res.getColumnIndex(APPLICANT_OLUMN_PHONE)));
            String age = res.getString((res.getColumnIndex(APPLICANT_COLUMN_AGE)));
            String event = res.getString((res.getColumnIndex(APPLICANT_COLUMN_PROJECT)));
            String cnic = res.getString((res.getColumnIndex(APPLICANT_COLUMN_CNIC)));

            // craeting Event oject to store the info. reterieved from database
            Registration registration = new Registration(id , name, sureName ,  event , age, cnic);
            registrationList.add(registration);
            res.moveToNext();
        }
        return registrationList;
    }

    /*
    public ArrayList<String> getNames(){
        ArrayList<String> Titles = new ArrayList<String>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select title from EVENT", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){


            String title = res.getString(res.getColumnIndex(EVENT_COLUMN_TITLE));
            Titles.add(title);
            res.moveToNext();
        }
        return Titles;

    }
*/
}