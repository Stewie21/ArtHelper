package com.example.arteme.myapplication.tabs.ComOrd;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.arteme.myapplication.R;

public class TabFragmentComOrd2 extends  Fragment {

    private static final int LAYOUT = R.layout.tab2_comord;
    private View view;

    public static TabFragmentComOrd2 getInstance(){
        Bundle args = new Bundle();
        TabFragmentComOrd2 fragment = new TabFragmentComOrd2();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanseState){
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }


}
