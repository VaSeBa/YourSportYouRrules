package ru.vaseba.yoursportyourrules;

import android.app.Application;

import androidx.room.Room;

import ru.vaseba.yoursportyourrules.datebase.AppDatabase;
import ru.vaseba.yoursportyourrules.datebase.ExercisesDao;

public class App extends Application {
    private AppDatabase database;
    private ExercisesDao exercisesDao;


    public static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "app-db-name")
//                .addMigrations(AppDatabase.MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();

        exercisesDao = database.exercisesDao();

    }


    public AppDatabase getDatabase() {
        return database;
    }

    public ExercisesDao getExercisesDao() {
        return exercisesDao;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public void setExercisesDao(ExercisesDao exercisesDao) {
        this.exercisesDao = exercisesDao;
    }
}
