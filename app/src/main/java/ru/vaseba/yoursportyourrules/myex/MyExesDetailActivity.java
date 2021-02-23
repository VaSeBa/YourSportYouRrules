package ru.vaseba.yoursportyourrules.myex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.UUID;

import ru.vaseba.yoursportyourrules.App;
import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.stopwatch.StopwatchFragment;
import ru.vaseba.yoursportyourrules.wod.WOD;

public class MyExesDetailActivity extends AppCompatActivity {
    public static final String EXTRA_EXES_ID = "MyExesDetailActivity.EXTRA_EXES_ID";
    private Exercises exercises;
    private TextView textView;

    private EditText editText1;
    private EditText editText2;

    public static void start(Activity caller, Exercises exercises) {
        Intent intent = new Intent(caller, MyExesDetailActivity.class);
        if (exercises != null) {
            intent.putExtra(EXTRA_EXES_ID, exercises);
        }
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exes_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setTitle(getString(R.string.note_details_title));
        editText1 = findViewById(R.id.exes_text);
        editText2 = findViewById(R.id.exes_detail);

//        int wodId = (Integer)getIntent().getExtras().get(EXTRA_EXES_ID);

//        textView = (TextView) findViewById(R.id.exes_text);
//        textView = (TextView) findViewById(R.id.exes_detail);

        if (getIntent().hasExtra(EXTRA_EXES_ID)) {
            exercises = getIntent().getParcelableExtra(EXTRA_EXES_ID);
            editText1.setText(exercises.name);
            editText2.setText(exercises.detail);
        } else {
            exercises = new Exercises();
        }

        if (savedInstanceState == null) {
            StopwatchFragment stopwatch = new StopwatchFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.stopwatch_container, stopwatch);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_save:
                if (editText1.getText().length() > 0) {
                    exercises.name = editText1.getText().toString();
                    exercises.detail = editText2.getText().toString();

                    if (getIntent().hasExtra(EXTRA_EXES_ID)) {
                        App.getInstance().getExercisesDao().update(exercises);
                    } else {
                        App.getInstance().getExercisesDao().insert(exercises);
                    }
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
