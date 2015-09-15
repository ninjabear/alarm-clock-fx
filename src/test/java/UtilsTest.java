package test;

import core.weather.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ed on 15/03/14.
 */
public class UtilsTest {
    private static final double margin = 1 * Math.pow(10, -5); //-6 doesn't work with these tests!

    @Test
    public void testKelvinToCelsius() throws Exception {

        assertEquals(10, Utils.kelvinToCelsius(283.15), margin);
        assertEquals(44, Utils.kelvinToCelsius(317.15), margin);
        assertEquals(0.75, Utils.kelvinToCelsius(273.9), margin);
        assertEquals(-50.33, Utils.kelvinToCelsius(222.82), margin);

    }

    @Test
    public void testKnotsToMph() throws Exception {

        assertEquals(1.15078, Utils.knotsToMph(1.00), margin);
        assertEquals(17.95216, Utils.knotsToMph(15.6), margin);
        assertEquals(-12.08318, Utils.knotsToMph(-10.5), margin);
        assertEquals(0, Utils.knotsToMph(0.00), margin);

    }
}
