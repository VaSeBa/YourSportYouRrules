package ru.vaseba.yoursportyourrules.datebase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.vaseba.yoursportyourrules.myex.Exercises;
import ru.vaseba.yoursportyourrules.myex.MyExesDetailActivity;

@Database(entities = {Exercises.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExercisesDao exercisesDao();

//    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(final SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE Exercises ADD COLUMN history1 INTEGER DEFAULT 0 NOT NULL");
//            database.execSQL("ALTER TABLE Exercises ADD COLUMN history2 INTEGER DEFAULT 0 NOT NULL");
//            database.execSQL("ALTER TABLE Exercises ADD COLUMN history3 INTEGER DEFAULT 0 NOT NULL");
//        }
//    };

}
