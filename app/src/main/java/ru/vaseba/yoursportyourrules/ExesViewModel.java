package ru.vaseba.yoursportyourrules;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.vaseba.yoursportyourrules.myex.Exercises;

public class ExesViewModel extends ViewModel {
    private LiveData<List<Exercises>> exesLiveData = App.getInstance().getExercisesDao()
            .getAllLiveData();

    public LiveData<List<Exercises>> getExesLiveData() {
        return exesLiveData;
    }
}
