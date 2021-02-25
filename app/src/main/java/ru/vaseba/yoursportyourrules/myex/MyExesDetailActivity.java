package ru.vaseba.yoursportyourrules.myex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import ru.vaseba.yoursportyourrules.App;
import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.stopwatch.StopwatchFragment;


public class MyExesDetailActivity extends AppCompatActivity {
    public static final String EXTRA_EXES_ID = "MyExesDetailActivity.EXTRA_EXES_ID";

    public int uId;
    public Exercises exercises;
    public EditText editText1;
    public EditText editText2;
    public EditText editText3;
    public EditText editText4;
    public EditText editText5;
    public EditText editText6;
    public EditText editText7;
    public EditText editText8;
    public EditText editText9;
    public EditText editText10;
    public EditText editText11;
    public EditText editText12;
    public EditText editText13;
    public EditText editText14;
    public EditText editText15;
    public EditText editText16;
    public EditText editText17;
    public EditText editText18;
    public EditText editText19;
    public EditText editText20;
    public EditText editText21;
    public EditText editText22;


    private StopwatchFragment stopwatch;

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
        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.detail);
        editText3 = findViewById(R.id.history1);
        editText4 = findViewById(R.id.history2);
        editText5 = findViewById(R.id.history3);
        editText6 = findViewById(R.id.history4);
        editText7 = findViewById(R.id.history5);
        editText8 = findViewById(R.id.history6);
        editText9 = findViewById(R.id.history7);
        editText10 = findViewById(R.id.history8);
        editText11 = findViewById(R.id.history9);
        editText12 = findViewById(R.id.history10);
        editText13 = findViewById(R.id.history11);
        editText14 = findViewById(R.id.history12);
        editText15 = findViewById(R.id.history13);
        editText16 = findViewById(R.id.history14);
        editText17 = findViewById(R.id.history15);
        editText18 = findViewById(R.id.history16);
        editText19 = findViewById(R.id.history17);
        editText20 = findViewById(R.id.history18);
        editText21 = findViewById(R.id.history19);
        editText22 = findViewById(R.id.history20);

//        int wodId = (Integer)getIntent().getExtras().get(EXTRA_EXES_ID);
//        textView = (TextView) findViewById(R.id.exes_text);
//        textView = (TextView) findViewById(R.id.exes_detail);

        if (getIntent().hasExtra(EXTRA_EXES_ID)) {
            exercises = getIntent().getParcelableExtra(EXTRA_EXES_ID);
            editText1.setText(exercises.name);
            editText2.setText(exercises.detail);
            editText3.setText(exercises.history1);
            editText4.setText(exercises.history2);
            editText5.setText(exercises.history3);
            editText6.setText(exercises.history4);
            editText7.setText(exercises.history5);
            editText8.setText(exercises.history6);
            editText9.setText(exercises.history7);
            editText10.setText(exercises.history8);
            editText11.setText(exercises.history9);
            editText12.setText(exercises.history10);
            editText13.setText(exercises.history11);
            editText14.setText(exercises.history12);
            editText15.setText(exercises.history13);
            editText16.setText(exercises.history14);
            editText17.setText(exercises.history15);
            editText18.setText(exercises.history16);
            editText19.setText(exercises.history17);
            editText20.setText(exercises.history18);
            editText21.setText(exercises.history19);
            editText22.setText(exercises.history20);

        } else {
            exercises = new Exercises();
        }

        if (savedInstanceState == null) {
            stopwatch = new StopwatchFragment();
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
                    exercises.history1 = editText3.getText().toString();
                    exercises.history2 = editText4.getText().toString();
                    exercises.history3 = editText5.getText().toString();
                    exercises.history4 = editText6.getText().toString();
                    exercises.history5 = editText7.getText().toString();
                    exercises.history6 = editText8.getText().toString();
                    exercises.history7 = editText9.getText().toString();
                    exercises.history8 = editText10.getText().toString();
                    exercises.history9 = editText11.getText().toString();
                    exercises.history10 = editText12.getText().toString();
                    exercises.history11 = editText13.getText().toString();
                    exercises.history12 = editText14.getText().toString();
                    exercises.history13 = editText15.getText().toString();
                    exercises.history14 = editText16.getText().toString();
                    exercises.history15 = editText17.getText().toString();
                    exercises.history16 = editText18.getText().toString();
                    exercises.history17 = editText19.getText().toString();
                    exercises.history18 = editText20.getText().toString();
                    exercises.history19 = editText21.getText().toString();
                    exercises.history20 = editText22.getText().toString();

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
