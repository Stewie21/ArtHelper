package com.example.arteme.myapplication.weather.Interfaces;


import com.example.arteme.myapplication.weather.Channel;

public interface IWeatherReceiver {
    void onReceiveWeather(Channel channel);
}
