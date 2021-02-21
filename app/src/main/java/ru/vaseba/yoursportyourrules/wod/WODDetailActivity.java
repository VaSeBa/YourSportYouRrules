package ru.vaseba.yoursportyourrules.wod;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.stopwatch.StopwatchFragment;

public class WODDetailActivity extends AppCompatActivity {
    public static final String EXTRA_WOD_ID = "wodId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wod_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int wodId = (Integer)getIntent().getExtras().get(EXTRA_WOD_ID);
        String wodName = WOD.wods[wodId].getName();
        String wodDetail = WOD.wods[wodId].getDetail();

        TextView textView1 = (TextView)findViewById(R.id.wod_text);
        textView1.setText(wodName);

        TextView textView2 = (TextView)findViewById(R.id.wod_detail);
        textView2.setText(wodDetail);

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


}
