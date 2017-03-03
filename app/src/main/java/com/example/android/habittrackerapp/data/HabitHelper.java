package com.example.android.habittrackerapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NIKHIL on 02-03-2017.
 */

public class HabitHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habits.db";

    private static final int DATABASE_VERSION = 1;

    public HabitHelper(Context context) {
        super(context, DATABASE_NAME , null ,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" +
                HabitContract.HabitEntry.COLUMN_ID + (" INTEGER PRIMARY KEY AUTOINCREMENT,") +
                HabitContract.HabitEntry.COLUMN_HABIT_NAME+ (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_MONDAY + (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_TUESDAY + (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_WEDNESDAY+ (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_THURSDAY + (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_FRIDAY + (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_SATURDAY + (" TEXT NOT NULL,") +
                HabitContract.HabitEntry.COLUMN_SUNDAY + (" TEXT NOT NULL") +
                HabitContract.HabitEntry.COLUMN_FOOD + (" TEXT NOT NULL");

        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createHabit() {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Listening Music");
        values.put(HabitContract.HabitEntry.COLUMN_MONDAY, 0);
        values.put(HabitContract.HabitEntry.COLUMN_TUESDAY, 0);
        values.put(HabitContract.HabitEntry.COLUMN_WEDNESDAY, 1);
        values.put(HabitContract.HabitEntry.COLUMN_THURSDAY, 0);
        values.put(HabitContract.HabitEntry.COLUMN_FRIDAY, 0);
        values.put(HabitContract.HabitEntry.COLUMN_SATURDAY, 1);
        values.put(HabitContract.HabitEntry.COLUMN_SUNDAY, 1);
        values.put(HabitContract.HabitEntry.COLUMN_FOOD , "White Pasta");

        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);

    }

    private Cursor readHabit()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projections = {
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_SATURDAY,
                HabitContract.HabitEntry.COLUMN_SUNDAY
        };

        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }
}
