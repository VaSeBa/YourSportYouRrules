package ru.vaseba.yoursportyourrules.myex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.UUID;

import ru.vaseba.yoursportyourrules.R;
import ru.vaseba.yoursportyourrules.stopwatch.StopwatchFragment;
import ru.vaseba.yoursportyourrules.wod.WOD;

public class MyExesDetailActivity extends AppCompatActivity {
    public static final String EXTRA_EXES_ID = "exesId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exes_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        int exesId = (Integer)getIntent().getExtras().get(EXTRA_EXES_ID);

//        String exesName = WOD.wods[wodId].getName();
//        String exesDetail = WOD.wods[wodId].getDetail();
//
//        TextView textView1 = (TextView)findViewById(R.id.exes_text);
//        textView1.setText(exesName);
//
//        TextView textView2 = (TextView)findViewById(R.id.ex_details);
//        textView2.setText(exesDetail);

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
