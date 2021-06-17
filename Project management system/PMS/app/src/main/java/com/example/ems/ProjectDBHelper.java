package com.example.ems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ProjectDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName2.db";
    public static final String PROJECT_TABLE_NAME = "PROJECT";
    public static final String PROJECT_COLUMN_ID = "id";
    public static final String PROJECT_COLUMN_TITLE = "title";
    public static final String PROJECT_COLUMN_MANAGER = "manager";
    public static final String PROJECT_COLUMN_TYPE = "type";
    public static final String PROJECT_COLUMN_DATE = "Date";
    public static final String EVENT_COLUMN_BUDGET = "budget";
    public static final String PROJECT_COLUMN_STATUS = "status";
    public static final String EVENT_COLUMN_DESC = "Description";
    private HashMap hp;

    public ProjectDBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table EVENT " +
                        "(id integer primary key AUTOINCREMENT , title text,organizer text,event text,budget text, Date text, Description text , max_limit text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS EVENTS");
        onCreate(db);
    }

    public boolean insertEvent (String title, String organizer,String event, String budget, String Date,String Description ,String max_limit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROJECT_COLUMN_TITLE, title);
        contentValues.put(PROJECT_COLUMN_MANAGER, organizer);
        contentValues.put(EVENT_COLUMN_BUDGET, budget);
        contentValues.put(PROJECT_COLUMN_DATE, Date);
        contentValues.put(PROJECT_COLUMN_STATUS, max_limit);
        contentValues.put(EVENT_COLUMN_DESC, Description);
        contentValues.put(PROJECT_COLUMN_TYPE, event);
        db.insert(PROJECT_TABLE_NAME, null, contentValues);
        return true;
    }


    public Project getData(int Id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from EVENT where id="+Id, null );
        res.moveToFirst();
        String id = res.getString((res.getColumnIndex("id")));
        String title = res.getString(res.getColumnIndex(PROJECT_COLUMN_TITLE));
        String organizer = res.getString(res.getColumnIndex(PROJECT_COLUMN_MANAGER));
        String description = res.getString(res.getColumnIndex(EVENT_COLUMN_DESC));
        String budget = res.getString(res.getColumnIndex(EVENT_COLUMN_BUDGET));
        String event_type = res.getString(res.getColumnIndex(PROJECT_COLUMN_TYPE));
        String date = res.getString(res.getColumnIndex(PROJECT_COLUMN_DATE));
        String max_limit = res.getString(res.getColumnIndex(PROJECT_COLUMN_STATUS));
        // craeting Event oject to store the info. reterieved from database
        Project project = new Project(title , organizer , description , max_limit , date , budget , event_type, id);
        return project;
    }

/*
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }
*/

    public Integer deleteProject(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("EVENT",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public boolean updateProject(Integer id, String title, String organizer, String event, String budget, String Date, String Description , String max_limit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROJECT_COLUMN_TITLE, title);
        contentValues.put(PROJECT_COLUMN_MANAGER, organizer);
        contentValues.put(EVENT_COLUMN_BUDGET, budget);
        contentValues.put(PROJECT_COLUMN_DATE, Date);
        contentValues.put(PROJECT_COLUMN_STATUS, max_limit);
        contentValues.put(EVENT_COLUMN_DESC, Description);
        contentValues.put(PROJECT_COLUMN_TYPE, event);
        db.update("EVENT", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public List<Project> getAllProjects() {
        //ArrayList<String> array_list = new ArrayList<String>();
        List<Project> projectList = new ArrayList<>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from EVENT", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            String id = res.getString((res.getColumnIndex("id")));
            String title = res.getString(res.getColumnIndex(PROJECT_COLUMN_TITLE));
            String organizer = res.getString(res.getColumnIndex(PROJECT_COLUMN_MANAGER));
            String description = res.getString(res.getColumnIndex(EVENT_COLUMN_DESC));
            String budget = res.getString(res.getColumnIndex(EVENT_COLUMN_BUDGET));
            String event_type = res.getString(res.getColumnIndex(PROJECT_COLUMN_TYPE));
            String date = res.getString(res.getColumnIndex(PROJECT_COLUMN_DATE));
            String max_limit = res.getString(res.getColumnIndex(PROJECT_COLUMN_STATUS));
            Log.i("EVENT" , title );
            Project project = new Project(title , organizer , description, max_limit , date , budget , event_type , id );
            projectList.add(project);
            res.moveToNext();
        }
        return projectList;
    }

    public ArrayList<String> getNames(){
        ArrayList<String> Titles = new ArrayList<String>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select title from EVENT", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){


            String title = res.getString(res.getColumnIndex(PROJECT_COLUMN_TITLE));
            Titles.add(title);
            res.moveToNext();
        }
        return Titles;

    }
}