package ru.vaseba.yoursportyourrules.wod;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.adapters.CaptionedImagesAdapter;


public class WODFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragmen_wod, container, false);

        String[] wodNames = new String[WOD.wods.length];

        for (int i = 0; i < wodNames.length; i++) {
            wodNames[i] = WOD.wods[i].getName();
        }

        String[] wodDetail = new String[WOD.wods.length];

        for (int i = 0; i < wodDetail.length; i++) {
            wodDetail[i] = WOD.wods[i].getDetail();
        }

        int[] wodImages = new int[WOD.wods.length];

        for (int i = 0; i < wodImages.length; i++) {
            wodImages[i] = WOD.wods[i].getImg();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(wodNames, wodImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        pizzaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), WODDetailActivity.class);
                intent.putExtra(WODDetailActivity.EXTRA_WOD_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycler;
    }

}