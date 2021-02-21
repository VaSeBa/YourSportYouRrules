package ru.vaseba.yoursportyourrules.myex;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.vaseba.yoursportyourrules.R;

public class MyExesFragment extends Fragment {
    private RecyclerView mExesRecyclerView;
    private CrimeAdapter mAdapter;

    private class ExesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleTextView;
        private MyExes mMyExes;

        public ExesHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_exes, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.exes_text);
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

    private class CrimeAdapter extends RecyclerView.Adapter<ExesHolder> {

        private List<MyExes> mMyExes;

        public CrimeAdapter(List<MyExes> exes) {
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
//            holder.bind(exes);
        }

        @Override
        public int getItemCount() {
            return mMyExes.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_exes, container,
                false);
        mExesRecyclerView = (RecyclerView) view.findViewById(R.id.exes_recycler);
        mExesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ExesLab exesLab = ExesLab.get(getActivity());
        List<MyExes> crimes = exesLab.getExes();
        mAdapter = new CrimeAdapter(crimes);
        mExesRecyclerView.setAdapter(mAdapter);
    }

}
