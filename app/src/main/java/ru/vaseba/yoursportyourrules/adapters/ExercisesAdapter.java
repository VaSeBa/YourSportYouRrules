package ru.vaseba.yoursportyourrules.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import java.util.List;

import ru.vaseba.yoursportyourrules.App;
import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.myex.Exercises;
import ru.vaseba.yoursportyourrules.myex.MyExesDetailActivity;


public class ExercisesAdapter
        extends RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>{

    private SortedList<Exercises> sortedList;

    public ExercisesAdapter() {

        sortedList = new SortedList<>(Exercises.class, new SortedList.Callback<Exercises>() {

            @Override
            public int compare(Exercises o1, Exercises o2) {
                return 0;
            }

            @Override
            public void onChanged(int position, int count) {
                notifyItemChanged(position, count);
            }

            @Override
            public boolean areContentsTheSame(Exercises oldItem, Exercises newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areItemsTheSame(Exercises item1, Exercises item2) {
                return item1.uId == item2.uId;
            }

            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }
        });
    }

    @NonNull
    @Override
    public ExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExercisesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_exes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesViewHolder holder, int position) {
        holder.bind(sortedList.get(position));
    }

    @Override
    public int getItemCount() {
        return sortedList.size();
    }

    public void setItems(List<Exercises> exercises) {
        sortedList.replaceAll(exercises);
    }

    static class ExercisesViewHolder extends RecyclerView.ViewHolder {

        TextView exeText;
        View delete;
        ImageView imageView;
        Exercises exercises;


        public ExercisesViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyExesDetailActivity.start((Activity) itemView.getContext(), exercises);
                }
            });

            exeText = itemView.findViewById(R.id.ex_title);
            delete =  itemView.findViewById(R.id.delete);
            imageView = itemView.findViewById(R.id.image_ex);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.getInstance().getExercisesDao().delete(exercises);
                }
            });

        }

        public void bind(Exercises exercises){
            this.exercises = exercises;

            exeText.setText(exercises.name);

        }
    }


}

