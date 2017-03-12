package com.example.arteme.myapplication.tabs.ShootCond;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.arteme.myapplication.R;
import com.example.arteme.myapplication.weather.Channel;
import com.example.arteme.myapplication.weather.Interfaces.IWeatherReceiver;
import com.example.arteme.myapplication.weather.WeatherGetter;
import com.example.arteme.myapplication.weather.data.Item;

public class TabFragmentShootCond1 extends Fragment {

    private static final int LAYOUT = R.layout.tab1_shootcond;
    private View view;
    private Button btnSССompose, btnSСDownload, btnSСFill, btnSCBack;
    private LinearLayout eathContitionsLayout, meteoSrLayout;
    private EditText editPress, editTemper, editDirection, editWindSpeed, editHeightMeteo;
    private EditText edtMeteoT02, edtMeteoT04, edtMeteoT08, edtMeteoT12, edtMeteoT16, edtMeteoT20, edtMeteoT24, edtMeteoT30, edtMeteoT40;

    private IWeatherReceiver mIWeatherReceiver = new IWeatherReceiver() {
        @Override
        public void onReceiveWeather(Channel channel) {
            Item item = channel.getItem();
            editPress.setText(Integer.toString(item.getAtmosphere()));
            editDirection.setText(Integer.toString(item.getWindDirection()));
            editHeightMeteo.setText("0");
            editTemper.setText(Integer.toString(item.getTemperature()));
            editWindSpeed.setText(Double.toString(item.getWindSpeed()));
        }
    };

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

                EditText[] arrEditMeteoT = new EditText[9];
                edtMeteoT02 = (EditText) view.findViewById(R.id.edtMeteoT02);
                arrEditMeteoT[0] = edtMeteoT02;
                edtMeteoT04 = (EditText) view.findViewById(R.id.edtMeteoT04);
                arrEditMeteoT[1] = edtMeteoT04;
                edtMeteoT08 = (EditText) view.findViewById(R.id.edtMeteoT08);
                arrEditMeteoT[2] = edtMeteoT08;
                edtMeteoT12 = (EditText) view.findViewById(R.id.edtMeteoT12);
                arrEditMeteoT[3] = edtMeteoT12;
                edtMeteoT16 = (EditText) view.findViewById(R.id.edtMeteoT16);
                arrEditMeteoT[4] = edtMeteoT16;
                edtMeteoT20 = (EditText) view.findViewById(R.id.edtMeteoT20);
                arrEditMeteoT[5] = edtMeteoT20;
                edtMeteoT24 = (EditText) view.findViewById(R.id.edtMeteoT24);
                arrEditMeteoT[6] = edtMeteoT24;
                edtMeteoT30 = (EditText) view.findViewById(R.id.edtMeteoT30);
                arrEditMeteoT[7] = edtMeteoT30;
                edtMeteoT40 = (EditText) view.findViewById(R.id.edtMeteoT40);
                arrEditMeteoT[8] = edtMeteoT40;

                editTemper = (EditText) view.findViewById(R.id.editTemper);


                for(int i = 0; i < arrEditMeteoT.length; i++)
                    arrEditMeteoT[i].setText(strDelTv(delTv(Integer.valueOf(editTemper.getText().toString()))));
            }
        });

        btnSСDownload = (Button) view.findViewById(R.id.btnSСDownload);
        btnSСDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WeatherGetter(getContext(), mIWeatherReceiver).uploadWeather();
            }
        });

        btnSCBack = (Button) view.findViewById(R.id.btnBackMeteo);
        btnSCBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                eathContitionsLayout.setVisibility(LinearLayout.VISIBLE);
                meteoSrLayout.setVisibility(LinearLayout.GONE);
            }
        });
        //btnSСFill = (Button) view.findViewById(R.id.btnSСFill);
    }

     private double delTv(double realT){

        double arrDelTv[] = {0.5, 1, 1.5, 2, 3.5, 4.5};
        double retDelTv = 0;

        if(realT < 0)
            retDelTv = realT - 15.9;
        else if(realT >= 0 & realT <= 5)
            retDelTv = (realT + arrDelTv[0]) - 15.9;
        else if(realT > 5 & realT < 10)
            retDelTv = (realT + arrDelTv[0] + 0.1*(realT - 5)) - 15.9;
         else if(realT >= 10 & realT <= 15)
            retDelTv = (realT + arrDelTv[1]) - 15.9;
         else if(realT > 15 & realT < 20)
            retDelTv = (realT + arrDelTv[1] + 0.1*(realT - 15)) - 15.9;
         else if(realT >= 20 & realT <= 25)
            retDelTv = (realT + arrDelTv[2] + 0.1*(realT - 20)) - 15.9;
         else if(realT > 25 & realT <= 30)
            retDelTv = (realT + arrDelTv[3] + 0.3*(realT - 25)) - 15.9;
         else if(realT > 30 & realT <= 40)
            retDelTv = (realT + arrDelTv[4] + 0.1*(realT - 30)) - 15.9;
         else
            retDelTv = (realT + arrDelTv[5]) - 15.9;

         return Math.round(retDelTv);
     }

    private String strDelTv(double delTv){
        String retStrDelTv = "";

        if(delTv < 10)
            retStrDelTv ="0" + String.valueOf((int)delTv);

        return retStrDelTv;
    }
}
