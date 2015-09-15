package core.weather;

/**
 * Created by Ed on 15/03/14.
 */
public class Utils {

    private Utils() { }

    public static double kelvinToCelsius(Double kelvin)
    {
        if (kelvin==null)
            throw new IllegalArgumentException("supplied temp in kelvin null");

        return kelvin-273.15;
    }



    public static double knotsToMph(Double knots)
    {
        if (knots==null)
            throw new IllegalArgumentException("supplied knots is null");

        return knots*1.15078;
    }
}
