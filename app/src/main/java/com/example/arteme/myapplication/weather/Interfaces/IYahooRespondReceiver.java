package com.example.arteme.myapplication.weather.Interfaces;


import com.example.arteme.myapplication.weather.Channel;

public interface IYahooRespondReceiver {
    void onReceiveSuccessRespond(Channel channel);
    void onReceiveFailureRespond(Exception e);
}
