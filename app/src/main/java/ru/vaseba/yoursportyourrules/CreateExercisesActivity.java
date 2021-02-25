package ru.vaseba.yoursportyourrules;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class CreateExercisesActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private EditText nameEdit;
    private EditText detailEdit;
    private FloatingActionButton mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercises);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

       nameEdit = (EditText) findViewById(R.id.name);
       detailEdit = (EditText) findViewById(R.id.detail);



    }

    public void onClickDone(View view) {

        CharSequence text = "Список упражнений добавлен";
        int duration = Snackbar.LENGTH_SHORT;

        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);
        snackbar.setAction("Отмена", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(CreateExercisesActivity.this, "Отменено!",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }


}
