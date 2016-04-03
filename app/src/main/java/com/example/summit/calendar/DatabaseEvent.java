package com.example.summit.calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by Summit on 4/1/2016.
 */
public class DatabaseEvent extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Event.db";
    public static final String TABLE_NAME ="Event";
        public DatabaseEvent(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT,Day INTEGER, Month INTEGER, Year INTEGER, Hour INTEGER, Minute INTEGER, Location TEXT, Duration TEXT, Description TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData( String title, int day, int month, int year, int hour, int minute, String location, String duration, String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Title", title);
        contentValues.put("Day",day);
        contentValues.put("Month",month);
        contentValues.put("Year",year);
        contentValues.put("Hour",hour);
        contentValues.put("Minute",minute);
        contentValues.put("Location",location);
        contentValues.put("Duration",duration);
        contentValues.put("Description",description);
             //contentValues.put("Reminder",reminder);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result ==-1)
            return false;
        else
            return true;
    }


}
