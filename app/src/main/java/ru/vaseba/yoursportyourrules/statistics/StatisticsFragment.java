package ru.vaseba.yoursportyourrules.statistics;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.vaseba.yoursportyourrules.ExesViewModel;
import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.adapters.ExercisesAdapter;
import ru.vaseba.yoursportyourrules.myex.Exercises;


public class StatisticsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView exesRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_statistics, container, false);

//        List <Exercises> exercisesList = App.getInstance().getExercisesDao();
        ExercisesAdapter adapter = new ExercisesAdapter();
        exesRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        exesRecycler.setLayoutManager(layoutManager);

        ExesViewModel viewModel = ViewModelProviders.of(this)
                .get(ExesViewModel.class);
        viewModel.getExesLiveData().observe(this, new Observer<List<Exercises>>() {
            @Override
            public void onChanged(List<Exercises> exercises) {
                adapter.setItems(exercises);
            }
        });

        return exesRecycler;
    }
}