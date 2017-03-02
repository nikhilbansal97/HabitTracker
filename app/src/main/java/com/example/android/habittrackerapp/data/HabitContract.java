package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by NIKHIL on 02-03-2017.
 */

public class HabitContract {

    private HabitContract(){}

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habit";

        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "habit name";
        public static final String COLUMN_MONDAY = "monday";
        public static final String COLUMN_TUESDAY = "tuesday";
        public static final String COLUMN_WEDNESDAY = "wednesday";
        public static final String COLUMN_THURSDAY = "thursday";
        public static final String COLUMN_FRIDAY = "friday";
        public static final String COLUMN_SATURDAY = "saturday";
        public static final String COLUMN_SUNDAY = "sunday";
        public static final String COLUMN_FOOD = "food";

        public static final int YES = 1;
        public static final int NO = 0;

    }

}
