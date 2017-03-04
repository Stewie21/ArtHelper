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
import android.widget.Spinner;

import com.example.arteme.myapplication.R;
import com.example.arteme.myapplication.weather.Channel;
import com.example.arteme.myapplication.weather.Interfaces.IWeatherReceiver;
import com.example.arteme.myapplication.weather.WeatherGetter;
import com.example.arteme.myapplication.weather.data.Item;

public class TabFragmentShootCond1 extends Fragment {

    private static final int LAYOUT = R.layout.tab1_shootcond;
    private View view;
    private Button btnSСDownload;
    private Button btnSССompose;
    private Button btnSСFill;
    private EditText editPress;
    private EditText editTemper;
    private EditText editDirection;
    private EditText editWindSpeed;
    private EditText editHeightMeteo;

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
        initSpinner();
        initButtons();
        initEditors();
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
        btnSСDownload = (Button) view.findViewById(R.id.btnSСDownload);
        btnSСDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WeatherGetter(getContext(), mIWeatherReceiver).uploadWeather();
            }
        });
        //btnSССompose = (Button) view.findViewById(R.id.btnSССompose);
        //btnSСFill = (Button) view.findViewById(R.id.btnSСFill);
    }

    private void initEditors() {
        editPress = (EditText) view.findViewById(R.id.editPress);
        editTemper = (EditText) view.findViewById(R.id.editTemper);
        editDirection = (EditText) view.findViewById(R.id.editDirection);
        editWindSpeed = (EditText) view.findViewById(R.id.editWindSpeed);
        editHeightMeteo = (EditText) view.findViewById(R.id.editHeightMeteo);
    }

}
