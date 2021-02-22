package ru.vaseba.yoursportyourrules;

import android.content.ContentValues;
import android.content.Context;
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

import ru.vaseba.yoursportyourrules.datebase.MyExesDBHelper;
import ru.vaseba.yoursportyourrules.datebase.MyExesDBSchema;
import ru.vaseba.yoursportyourrules.myex.ExesLab;
import ru.vaseba.yoursportyourrules.myex.MyExes;


public class CreateExercisesActivity extends AppCompatActivity implements View.OnClickListener {
    private MyExes mMyExes;
    private ExesLab mExesLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private MyExesDBHelper mMyExesDBHelper;
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

       nameEdit = (EditText) findViewById(R.id.ex_name);
       detailEdit = (EditText) findViewById(R.id.ex_details);

       mButton = (FloatingActionButton) findViewById(R.id.a_button);
       mButton.setOnClickListener(this);

        mMyExesDBHelper = new MyExesDBHelper(this);
    }

    public void onClickDone(View view) {
//        mMyExes = new MyExes();
//        mExesLab.addExes(mMyExes);
        mDatabase = mMyExesDBHelper.getWritableDatabase();


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

    @Override
    public void onClick(View v) {
        String name = nameEdit.getText().toString();
        String detail = detailEdit.getText().toString();

        mDatabase = mMyExesDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.a_button:
                contentValues.put(MyExesDBHelper.NAME, name);
                contentValues.put(MyExesDBHelper.DETAIL, detail);

                mDatabase.insert(MyExesDBHelper.TABLE_NAME, null, contentValues);
                CharSequence text = "Список упражнений добавлен";
                int duration = Snackbar.LENGTH_SHORT;
                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);

                break;

        }
    }
}
