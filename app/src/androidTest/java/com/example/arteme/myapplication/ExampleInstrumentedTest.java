package com.example.arteme.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.arteme.myapplication.weather.Channel;
import com.example.arteme.myapplication.weather.data.Item;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private JSONObject jsonObject = new JSONObject("{\n" +
            " \"query\": {\n" +
            "  \"count\": 1,\n" +
            "  \"created\": \"2017-02-27T19:41:30Z\",\n" +
            "  \"lang\": \"ru\",\n" +
            "  \"results\": {\n" +
            "   \"channel\": {\n" +
            "    \"units\": {\n" +
            "     \"distance\": \"mi\",\n" +
            "     \"pressure\": \"in\",\n" +
            "     \"speed\": \"mph\",\n" +
            "     \"temperature\": \"F\"\n" +
            "    },\n" +
            "    \"title\": \"Yahoo! Weather - Nome, AK, US\",\n" +
            "    \"link\": \"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\",\n" +
            "    \"description\": \"Yahoo! Weather for Nome, AK, US\",\n" +
            "    \"language\": \"en-us\",\n" +
            "    \"lastBuildDate\": \"Mon, 27 Feb 2017 10:41 AM AKST\",\n" +
            "    \"ttl\": \"60\",\n" +
            "    \"location\": {\n" +
            "     \"city\": \"Nome\",\n" +
            "     \"country\": \"United States\",\n" +
            "     \"region\": \" AK\"\n" +
            "    },\n" +
            "    \"wind\": {\n" +
            "     \"chill\": \"-4\",\n" +
            "     \"direction\": \"270\",\n" +
            "     \"speed\": \"14\"\n" +
            "    },\n" +
            "    \"atmosphere\": {\n" +
            "     \"humidity\": \"80\",\n" +
            "     \"pressure\": \"1019.0\",\n" +
            "     \"rising\": \"0\",\n" +
            "     \"visibility\": \"16.1\"\n" +
            "    },\n" +
            "    \"astronomy\": {\n" +
            "     \"sunrise\": \"9:17 am\",\n" +
            "     \"sunset\": \"7:13 pm\"\n" +
            "    },\n" +
            "    \"image\": {\n" +
            "     \"title\": \"Yahoo! Weather\",\n" +
            "     \"width\": \"142\",\n" +
            "     \"height\": \"18\",\n" +
            "     \"link\": \"http://weather.yahoo.com\",\n" +
            "     \"url\": \"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif\"\n" +
            "    },\n" +
            "    \"item\": {\n" +
            "     \"title\": \"Conditions for Nome, AK, US at 10:00 AM AKST\",\n" +
            "     \"lat\": \"64.499474\",\n" +
            "     \"long\": \"-165.405792\",\n" +
            "     \"link\": \"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\",\n" +
            "     \"pubDate\": \"Mon, 27 Feb 2017 10:00 AM AKST\",\n" +
            "     \"condition\": {\n" +
            "      \"code\": \"28\",\n" +
            "      \"date\": \"Mon, 27 Feb 2017 10:00 AM AKST\",\n" +
            "      \"temp\": \"-9\",\n" +
            "      \"text\": \"Mostly Cloudy\"\n" +
            "     },\n" +
            "     \"forecast\": [\n" +
            "      {\n" +
            "       \"code\": \"30\",\n" +
            "       \"date\": \"27 Feb 2017\",\n" +
            "       \"day\": \"Mon\",\n" +
            "       \"high\": \"18\",\n" +
            "       \"low\": \"0\",\n" +
            "       \"text\": \"Partly Cloudy\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"32\",\n" +
            "       \"date\": \"28 Feb 2017\",\n" +
            "       \"day\": \"Tue\",\n" +
            "       \"high\": \"6\",\n" +
            "       \"low\": \"-3\",\n" +
            "       \"text\": \"Sunny\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"30\",\n" +
            "       \"date\": \"01 Mar 2017\",\n" +
            "       \"day\": \"Wed\",\n" +
            "       \"high\": \"2\",\n" +
            "       \"low\": \"-9\",\n" +
            "       \"text\": \"Partly Cloudy\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"32\",\n" +
            "       \"date\": \"02 Mar 2017\",\n" +
            "       \"day\": \"Thu\",\n" +
            "       \"high\": \"4\",\n" +
            "       \"low\": \"-5\",\n" +
            "       \"text\": \"Sunny\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"30\",\n" +
            "       \"date\": \"03 Mar 2017\",\n" +
            "       \"day\": \"Fri\",\n" +
            "       \"high\": \"7\",\n" +
            "       \"low\": \"-7\",\n" +
            "       \"text\": \"Partly Cloudy\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"30\",\n" +
            "       \"date\": \"04 Mar 2017\",\n" +
            "       \"day\": \"Sat\",\n" +
            "       \"high\": \"11\",\n" +
            "       \"low\": \"5\",\n" +
            "       \"text\": \"Partly Cloudy\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"30\",\n" +
            "       \"date\": \"05 Mar 2017\",\n" +
            "       \"day\": \"Sun\",\n" +
            "       \"high\": \"12\",\n" +
            "       \"low\": \"2\",\n" +
            "       \"text\": \"Partly Cloudy\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"34\",\n" +
            "       \"date\": \"06 Mar 2017\",\n" +
            "       \"day\": \"Mon\",\n" +
            "       \"high\": \"2\",\n" +
            "       \"low\": \"-15\",\n" +
            "       \"text\": \"Mostly Sunny\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"32\",\n" +
            "       \"date\": \"07 Mar 2017\",\n" +
            "       \"day\": \"Tue\",\n" +
            "       \"high\": \"-2\",\n" +
            "       \"low\": \"-16\",\n" +
            "       \"text\": \"Sunny\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"code\": \"28\",\n" +
            "       \"date\": \"08 Mar 2017\",\n" +
            "       \"day\": \"Wed\",\n" +
            "       \"high\": \"2\",\n" +
            "       \"low\": \"-11\",\n" +
            "       \"text\": \"Mostly Cloudy\"\n" +
            "      }\n" +
            "     ],\n" +
            "     \"description\": \"<![CDATA[<img src=\\\"http://l.yimg.com/a/i/us/we/52/28.gif\\\"/>\\n<BR />\\n<b>Current Conditions:</b>\\n<BR />Mostly Cloudy\\n<BR />\\n<BR />\\n<b>Forecast:</b>\\n<BR /> Mon - Partly Cloudy. High: 18Low: 0\\n<BR /> Tue - Sunny. High: 6Low: -3\\n<BR /> Wed - Partly Cloudy. High: 2Low: -9\\n<BR /> Thu - Sunny. High: 4Low: -5\\n<BR /> Fri - Partly Cloudy. High: 7Low: -7\\n<BR />\\n<BR />\\n<a href=\\\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\\\">Full Forecast at Yahoo! Weather</a>\\n<BR />\\n<BR />\\n(provided by <a href=\\\"http://www.weather.com\\\" >The Weather Channel</a>)\\n<BR />\\n]]>\",\n" +
            "     \"guid\": {\n" +
            "      \"isPermaLink\": \"false\"\n" +
            "     }\n" +
            "    }\n" +
            "   }\n" +
            "  }\n" +
            " }\n" +
            "}");

    public ExampleInstrumentedTest() throws JSONException {
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.arteme.myapplication", appContext.getPackageName());
    }

    @Test
    public void channelJsonPopulate() throws Exception {

        Channel channel = new Channel();
        channel.populate(jsonObject.optJSONObject("query").optJSONObject("results").optJSONObject("channel"));
        Item item = channel.getItem();
        assertNotNull(item);
    }

    @Test
    public void checkNegativeTemperature() throws Exception {
        Channel channel = new Channel();
        channel.populate(jsonObject.optJSONObject("query").optJSONObject("results").optJSONObject("channel"));
        Item item = channel.getItem();
        assertEquals("-22", Integer.toString(item.getTemperature()));
    }
}