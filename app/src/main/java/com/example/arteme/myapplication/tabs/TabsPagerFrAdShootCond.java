package com.example.arteme.myapplication.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.arteme.myapplication.tabs.ShootCond.TabFragmentShootCond1;
import com.example.arteme.myapplication.tabs.ShootCond.TabFragmentShootCond2;
import com.example.arteme.myapplication.tabs.ShootCond.TabFragmentShootCond3;
import com.example.arteme.myapplication.tabs.ShootCond.TabFragmentShootCond4;

public class TabsPagerFrAdShootCond extends FragmentPagerAdapter {

    private String[] tabs;

    public TabsPagerFrAdShootCond(FragmentManager fm){
        super(fm);
        tabs = new String[]{"Метео", "Баллистика", "Разведка", "Поправки"};
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return TabFragmentShootCond1.getInstance();
            case 1:
                return TabFragmentShootCond2.getInstance();
            case 2:
                return TabFragmentShootCond3.getInstance();
            case 3:
                return TabFragmentShootCond4.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
