package com.example.arteme.myapplication.weather;

import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;

import com.example.arteme.myapplication.weather.Interfaces.IYahooRespondReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class YahooWeatherAsyncTask extends AsyncTask<Location, Void, Channel> {

    private IYahooRespondReceiver mIYahooRespondReceiver;
    private Location mLocation;
    private Exception error;

    public YahooWeatherAsyncTask(IYahooRespondReceiver iYahooRespondReceiver) {
        mIYahooRespondReceiver = iYahooRespondReceiver;
    }

    @Override
    protected Channel doInBackground(Location... locations) {
        mLocation = locations[0];
        Channel channel = new Channel();

        //String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\") and u='" + unit + "'", location);

        String YQL = "select * from weather.forecast where woeid in (SELECT woeid FROM geo.places WHERE text=\"(" + mLocation.getLatitude() + "," + mLocation.getLongitude() + ")\") and u='f'";
        String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

        try {
            URL url = new URL(endpoint);

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);

            InputStream inputStream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            reader.close();

            JSONObject data = new JSONObject(result.toString());

            JSONObject queryResults = data.optJSONObject("query");

            int count = queryResults.optInt("count");

            if (count == 0) {
                error = new LocationWeatherException("No weather information found for " + mLocation);
                return null;
            }

            JSONObject channelJSON = queryResults.optJSONObject("results").optJSONObject("channel");
            channel.populate(channelJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return channel;
    }

    private class LocationWeatherException extends Exception {
        LocationWeatherException(String detailMessage) {
            super(detailMessage);
        }
    }

        @Override
    protected void onPostExecute(Channel channel) {
            if (channel == null && error != null) {
                mIYahooRespondReceiver.onReceiveFailureRespond(error);
            } else {
                mIYahooRespondReceiver.onReceiveSuccessRespond(channel);
            }
    }
}
