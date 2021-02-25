package ru.vaseba.yoursportyourrules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import ru.vaseba.yoursportyourrules.myex.MyExesDetailActivity;
import ru.vaseba.yoursportyourrules.myex.MyExesFragment;
import ru.vaseba.yoursportyourrules.statistics.StatisticsFragment;
import ru.vaseba.yoursportyourrules.wod.WODFragment;

public class MainActivity extends AppCompatActivity {

    private long backPressed;
    private Toast makeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void onClickDone(View view) {
        MyExesDetailActivity.start(MainActivity.this, null);
    }



    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new MyExesFragment();
                case 2:
                    return new WODFragment();
//                case 3:
//                    return new StatisticsFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.my_ex);
                case 2:
                    return getResources().getText(R.string.wod_ex);
//                case 3:
//                    return getResources().getText(R.string.stat);
            }
            return null;
        }
    }

    //Закрытие приложения двойным нажатием
    @Override
    public void onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()) {
            makeText.cancel();
            super.onBackPressed();
            return;
        } else {
            makeText = Toast.makeText(getBaseContext(), "Нажмите дважды, что бы выйти", Toast.LENGTH_SHORT);
            makeText.show();
        }
        backPressed = System.currentTimeMillis();
    }

}