package ru.vaseba.yoursportyourrules.datebase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.vaseba.yoursportyourrules.myex.Exercises;

@Database(entities = {Exercises.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExercisesDao exercisesDao();
}
