package com.example.arteme.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.arteme.myapplication.tabs.TabsPagerFrAdShootCond;

public class ActivityShootCond extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shootcond);

        initToolbar();
        initNavigationView();
        initTabs();

    }

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbarShootCond);
        toolbar.setTitle("Условия стрельбы");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initNavigationView(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_shootcond);
    }

    private void initTabs() {

        viewPager = (ViewPager) findViewById(R.id.viewPagerShootCond);
        TabsPagerFrAdShootCond adapter = new TabsPagerFrAdShootCond(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayoutShootCond);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
