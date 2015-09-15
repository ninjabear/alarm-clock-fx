package core.weather;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Ed on 14/03/14.
 */
public class WeatherFactory {

    private static URL weatherSource = null;
    private static final Object weatherLock = new Object();

    private WeatherFactory() { }

    private static URL getWeatherSource()
    {
        URL src;
        try {
            src = new URL( "http://api.openweathermap.org/data/2.5/weather?q=Colchester,uk" );
        } catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }

        return src;
    }

    private static String getWeatherJSON()
    {
        synchronized (weatherLock)
        {
            if (weatherSource==null)
                weatherSource=getWeatherSource();


            String json;

            try (Scanner c = new Scanner(weatherSource.openStream(), "UTF-8"))
            {
                json = c.useDelimiter("\\A").next();
            } catch (Exception e)
            {
                throw new RuntimeException(e);
            }

            return json;
        }
    }

    public static Weather buildWeatherFromJSON(String json)
    {
        return new Gson().fromJson(json, WeatherOpenWeatherMapOrg.class);
    }

    public static Weather getWeatherNow()
    {
        String weatherJSON = getWeatherJSON();
        return buildWeatherFromJSON(weatherJSON);
    }

}
