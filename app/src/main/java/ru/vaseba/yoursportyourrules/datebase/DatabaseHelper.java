package ru.vaseba.yoursportyourrules.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DETAIL = "detail";

    public static final int DB_VERSION = 1; // Версия базы данных
    public static final String DB_NAME = "exercisesDB"; // Имя базы данных
    public static final String TABLE_EXERCISE = "exercises";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_EXERCISE + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," + KEY_DETAIL + " text"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
