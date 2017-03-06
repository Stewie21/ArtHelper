package com.example.arteme.myapplication.tabs.ShootCond;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.arteme.myapplication.R;

public class TabFragmentShootCond1 extends Fragment {

    private static final int LAYOUT = R.layout.tab1_shootcond;
    private View view;
    private Button btnSССompose;
    private LinearLayout eathContitionsLayout;
    private LinearLayout meteoSrLayout;

    public static TabFragmentShootCond1 getInstance(){
        Bundle args = new Bundle();
        TabFragmentShootCond1 fragment = new TabFragmentShootCond1();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanseState){
        view = inflater.inflate(LAYOUT, container, false);
        eathContitionsLayout = (LinearLayout)view.findViewById(R.id.linearEathConditions);
        meteoSrLayout = (LinearLayout)view.findViewById(R.id.linearMeteoSr);
        initSpinner();
        initButtons();
        eathContitionsLayout.setVisibility(LinearLayout.VISIBLE);
        meteoSrLayout.setVisibility(LinearLayout.GONE);

        return view;
    }

    private void initSpinner(){

        Spinner spinnerWindSpeed;
        spinnerWindSpeed = (Spinner) view.findViewById(R.id.windSpeedSpinner);

        ArrayAdapter<CharSequence> adapterWindSpeed = ArrayAdapter.createFromResource(getContext(),
                R.array.wind_speed_array, android.R.layout.simple_spinner_item);

        spinnerWindSpeed.setAdapter(adapterWindSpeed);

    }

    private void initButtons() {
        btnSССompose = (Button) view.findViewById(R.id.btnSССompose);
        btnSССompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eathContitionsLayout.setVisibility(LinearLayout.GONE);
                meteoSrLayout.setVisibility(LinearLayout.VISIBLE);
            }
        });
        //btnSССompose = (Button) view.findViewById(R.id.btnSССompose);
        //btnSСFill = (Button) view.findViewById(R.id.btnSСFill);
    }
}
