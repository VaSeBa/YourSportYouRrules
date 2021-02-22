package ru.vaseba.yoursportyourrules.myex;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.vaseba.yoursportyourrules.R;

public class MyExesFragment extends Fragment {
    private RecyclerView mExesRecyclerView;
    private ExesAdapter mAdapter;
    private boolean mSubtitleVisible;
    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";

    private class ExesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleTextView;
        private MyExes mMyExes;

        public ExesHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_exes, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.ex_title);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), MyExesDetailActivity.class);
            startActivity(intent);
        }

        public void bind(MyExes exes) {
            mMyExes = exes;
            mTitleTextView.setText(mMyExes.getName());
//            mDateTextView.setText(mCrime.getDate().toString());
//            mSolvedImageView.setVisibility(crime.isSolved() ? View.VISIBLE : View.GONE);
        }

    }

    private class ExesAdapter extends RecyclerView.Adapter<ExesHolder> {

        private List<MyExes> mMyExes;

        public ExesAdapter(List<MyExes> exes) {
            mMyExes = exes;
        }

        @Override
        public ExesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ExesHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ExesHolder holder, int position) {
            MyExes exes = mMyExes.get(position);
            holder.bind(exes);
        }

        @Override
        public int getItemCount() {
            return mMyExes.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_exes, container,false);

        mExesRecyclerView = (RecyclerView) view.findViewById(R.id.exes_recycler);
        mExesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }

    private void updateSubtitle() {
        ExesLab exesLab = ExesLab.get(getActivity());
        int exesCount = exesLab.getExes().size();
        String subtitle = getString(R.string.subtitle_format, exesCount);

        if (!mSubtitleVisible) {
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private void updateUI() {
        ExesLab exesLab = ExesLab.get(getActivity());
        List<MyExes> exes = exesLab.getExes();
        if (mAdapter == null) {
            mAdapter = new ExesAdapter(exes);
            mExesRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        updateSubtitle();
    }

}
