package gui;

import core.time.TimeListener;
import core.time.TimeUpdate;
import core.time.Timer;
import core.weather.Utils;
import core.weather.Weather;
import core.weather.WeatherFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label time;
    @FXML
    private Label alarmset;
    @FXML
    private Label tempC;
    @FXML
    private Label weatherDesc;

    private TimeUpdate lastWeatherUpdate;
    private Timer t = null;
    private TimeListener l = new TimeListener() {
        @Override
        public void update(final TimeUpdate t) {
            if (!Platform.isFxApplicationThread())
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        updateClock(t);
                    }
                });
            else {
                updateClock(t);
            }
        }
    };

    private Weather w;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t = new Timer();
        t.addTimeListener(l);
        alarmset.setText("Alarm not set");
        w = WeatherFactory.getWeatherNow();
        updateWeather(w);
    }

    private void updateWeather(Weather w)
    {
        assert w!=null : "update with invalid weather? no";
        assert Platform.isFxApplicationThread();

        tempC.setText(String.format("%.1fC (%.1fC min / %.1fC max)",
                      Utils.kelvinToCelsius(w.getTempKelvin()),
                      Utils.kelvinToCelsius(w.getTempMinKelvin()),
                      Utils.kelvinToCelsius(w.getTempMaxKelvin())
                      ));

        weatherDesc.setText(w.getDescription().substring(0,1).toUpperCase() + w.getDescription().substring(1));
    }

    private void updateClock(final TimeUpdate t)
    {
        assert Platform.isFxApplicationThread();

        SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss EEEE, dd MMMM yyyy");
        String date = d.format(t.getDate());
        time.setText(date);

        checkWeatherUpdate(t);
    }


    private void checkWeatherUpdate(final TimeUpdate t)
    {
        if (lastWeatherUpdate == null)
        {
            lastWeatherUpdate = t;
        }

        if (t.hrsDiffFrom(lastWeatherUpdate)>0.25)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Weather w = WeatherFactory.getWeatherNow();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            updateWeather(w);
                        }
                    });
                }
            }).start();
        }
    }

}
