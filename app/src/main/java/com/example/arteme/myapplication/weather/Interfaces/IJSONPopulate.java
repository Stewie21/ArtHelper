package com.example.arteme.myapplication.weather.Interfaces;

import org.json.JSONObject;


public interface IJSONPopulate {
    void populate(JSONObject data);
    JSONObject toJSON();
}
