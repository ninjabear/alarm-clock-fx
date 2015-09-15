package core.weather;

/**
 * Created by Ed on 14/03/14.
 */
public interface Weather {

    public Double getLatitude();

    public Double getLongitude();

    public String getSunrise();

    public String getSunset();

    public String getCountry();

    public String getDescriptionShort();

    public String getDescription();

    public String getBase();

    public Double getTempKelvin();

    public Double getHumidity();

    public Double getPressure();

    public Double getTempMinKelvin();
    
    public Double getTempMaxKelvin();

    public Double getWindspeed();

    public Double getGustMax();

    public Double getWindDegrees();

    public Double getClouds();

    public String getDateTime();

    public String getId();

    public String getName();

}
