package ru.vaseba.yoursportyourrules.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.vaseba.yoursportyourrules.datebase.MyExesDBSchema.ExesTable;

public class MyExesDBHelper extends SQLiteOpenHelper {

    public static final String UUID = "uuid";
    public static final String NAME = "name";
    public static final String DETAIL = "detail";

    public static final int DB_VERSION = 1; // Версия базы данных
    public static final String DB_NAME = "exercisesDB"; // Имя базы данных

    public static final String TABLE_NAME = "exes";

    public MyExesDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_EXERCISE + "(" + KEY_ID
//                + " integer primary key," + KEY_NAME + " text," + KEY_DETAIL + " text"
//                + ")");
        db.execSQL("create table " + TABLE_NAME + "(" +
                " _id integer primary key autoincrement, " +
                UUID + ", " +
                NAME + ", " +
                DETAIL + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
