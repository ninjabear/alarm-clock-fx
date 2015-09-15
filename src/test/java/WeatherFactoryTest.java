package test;

import core.weather.Weather;
import core.weather.WeatherFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ed on 14/03/14.
 */
public class WeatherFactoryTest {

    private final String sampleJSON =
            "{\"coord\":{\"lon\":0.9,\"lat\":51.89},\"sys\":{\"message\":0.0086,\"country\":\"GB\",\"sunrise\":1394777486,\"sunset\":1394819969},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"02n\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":284.07,\"humidity\":70,\"pressure\":1023,\"temp_min\":283.15,\"temp_max\":286.15},\"wind\":{\"speed\":3.08,\"gust\":5.65,\"deg\":271},\"clouds\":{\"all\":8},\"dt\":1394832477,\"id\":2652618,\"name\":\"Colchester\",\"cod\":200}";


    @Test
    public void testBuildWeatherFromJSON() throws Exception {

        Weather w = WeatherFactory.buildWeatherFromJSON(sampleJSON);

        assertNotNull(w);
        assertEquals(Double.valueOf(0.9), w.getLongitude());
        assertEquals(Double.valueOf(51.89), w.getLatitude());
        assertEquals("GB", w.getCountry());
        assertEquals("1394777486", w.getSunrise());
        assertEquals("1394819969", w.getSunset());
        assertEquals("Clear", w.getDescriptionShort());
        assertEquals("sky is clear", w.getDescription());
        assertEquals("cmc stations", w.getBase());
        assertEquals(Double.valueOf(284.07), w.getTempKelvin());
        assertEquals(Double.valueOf(70.00), w.getHumidity());
        assertEquals(Double.valueOf(1023.00), w.getPressure());
        assertEquals(Double.valueOf(283.15), w.getTempMinKelvin());
        assertEquals(Double.valueOf(286.15), w.getTempMaxKelvin());
        assertEquals(Double.valueOf(3.08), w.getWindspeed());
        assertEquals(Double.valueOf(5.65), w.getGustMax());
        assertEquals(Double.valueOf(271), w.getWindDegrees());
        assertEquals(Double.valueOf(8), w.getClouds()); // wat
        assertEquals("1394832477", w.getDateTime());
        assertEquals("Colchester", w.getName());
        assertEquals("2652618", w.getId());

    }
}
