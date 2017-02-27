package com.example.arteme.myapplication.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.arteme.myapplication.tabs.ComOrd.TabFragmentComOrd1;
import com.example.arteme.myapplication.tabs.ComOrd.TabFragmentComOrd2;


public class TabsPagerFrAdComOrd extends FragmentPagerAdapter {

    private String[] tabs;

    public TabsPagerFrAdComOrd(FragmentManager fm){
        super(fm);
        tabs = new String[]{"Средства", "КНП и ОП"};
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return TabFragmentComOrd1.getInstance();
            case 1:
                return TabFragmentComOrd2.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
