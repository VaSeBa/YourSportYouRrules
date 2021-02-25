package ru.vaseba.yoursportyourrules.myex;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.vaseba.yoursportyourrules.App;
import ru.vaseba.yoursportyourrules.ExesViewModel;
import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.adapters.CaptionedImagesAdapter;
import ru.vaseba.yoursportyourrules.adapters.ExercisesAdapter;

public class MyExesFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView statsRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_my_exes, container, false);

//        List <Exercises> exercisesList = App.getInstance().getExercisesDao();
        ExercisesAdapter adapter = new ExercisesAdapter();
        statsRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        statsRecycler.setLayoutManager(layoutManager);

        ExesViewModel viewModel = ViewModelProviders.of(this).get(ExesViewModel.class);
        viewModel.getExesLiveData().observe(this, new Observer<List<Exercises>>() {
            @Override
            public void onChanged(List<Exercises> exercises) {
                adapter.setItems(exercises);
            }
        });

        return statsRecycler;
    }
}
