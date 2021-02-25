package ru.vaseba.yoursportyourrules.datebase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.vaseba.yoursportyourrules.myex.Exercises;

@Dao
public interface ExercisesDao {

    @Query("SELECT * FROM Exercises")
    List<Exercises> getAll();

    @Query("SELECT * FROM Exercises")
    LiveData<List<Exercises>> getAllLiveData();

    @Query("SELECT * FROM Exercises WHERE uId IN (:exesIds)")
    List<Exercises> loadAllByIds(int[] exesIds);

    @Query("SELECT * FROM Exercises WHERE uId = :uId LIMIT 1")
    Exercises findById(int uId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Exercises exercises);

    @Update
    void update(Exercises exercises);

    @Delete
    void delete(Exercises exercises);

}
