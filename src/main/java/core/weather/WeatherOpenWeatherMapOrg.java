package core.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ed on 14/03/14.
 */
public class WeatherOpenWeatherMapOrg implements Weather {

    private class Coord {
        private Double lat, lon;
    }

    private class Sys {
        private String message, country, sunrise, sunset;
    }

    private class LWeather {
        private String id, main, description, icon;
    }

    private class Main {
        private Double temp, humidity, pressure, temp_min, temp_max;
    }

    private class Wind {
        private Double speed, gust, deg;
    }

    private class Clouds {
        private Double all;
    }

    private Coord coord;
    private Sys sys;
    private List<LWeather> weather;
    private String base;
    private Main main;


    private Wind wind;
    private Clouds clouds;
    private String dt;
    private String id;
    private String name;
    private String cod;

    public Double getLatitude() {
        return coord.lat;
    }

    public Double getLongitude() {
        return coord.lon;
    }

    public String getSunrise() {
        return sys.sunrise;
    }

    public String getSunset() {
        return sys.sunset;
    }

    public String getCountry() {
        return sys.country;
    }

    public String getDescriptionShort() {
        return weather.get(0).main;
    }

    public String getDescription() {
        return weather.get(0).description;
    }

    public String getBase() {
        return base;
    }

    public Double getTempKelvin() {
        return main.temp;
    }

    public Double getHumidity() {
        return main.humidity;
    }

    public Double getPressure() {
        return main.pressure;
    }

    public Double getTempMinKelvin() {
        return main.temp_min;
    }

    public Double getTempMaxKelvin() {
        return main.temp_max;
    }

    public Double getWindspeed() {
        return wind.speed;
    }

    public Double getGustMax() {
        return wind.gust;
    }

    public Double getWindDegrees() {
        return wind.deg;
    }

    public Double getClouds() {
        return clouds.all;
    }

    public String getDateTime() {
        return dt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
