package com.example.arteme.myapplication.weather;


import com.example.arteme.myapplication.weather.Interfaces.IJSONPopulate;
import com.example.arteme.myapplication.weather.data.Item;

import org.json.JSONException;
import org.json.JSONObject;

public class Channel implements IJSONPopulate {

    private Item mItem;

    @Override
    public void populate(JSONObject data) {
        JSONObject atmosphere = data.optJSONObject("atmosphere");
        JSONObject wind = data.optJSONObject("wind");
        JSONObject temperature = data.optJSONObject("item");
        try {
            mItem = new Item(atmosphere.getDouble("pressure"), temperature.getInt("temp"), wind.getInt("direction"), wind.getDouble("speed"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    public Item getItem() {
        return mItem;
    }
}
