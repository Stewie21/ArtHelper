package com.example.arteme.myapplication.weather;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.example.arteme.myapplication.weather.Interfaces.IWeatherReceiver;
import com.example.arteme.myapplication.weather.Interfaces.IYahooRespondReceiver;

public class WeatherGetter implements LocationListener {
    private Context mContext;
    private IWeatherReceiver mIWeatherReceiver;

    private IYahooRespondReceiver mIYahooRespondReceiver = new IYahooRespondReceiver() {
        @Override
        public void onReceiveRespond(Channel channel) {
            mIWeatherReceiver.onReceiveWeather(channel);
        }
    };

    public WeatherGetter(Context context, IWeatherReceiver iWeatherReceiver) {
        mContext = context;
        mIWeatherReceiver = iWeatherReceiver;
    }

    public void uploadWeather() {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
