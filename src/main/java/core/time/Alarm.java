package core.time;

/**
 * Created by Ed on 15/03/14.
 */
public class Alarm {

    public enum AlarmType { HOUR, DATE, WEEKDAY, WEEKEND }

    private boolean isActive = false;
    private AlarmType type = null;

    public Alarm(AlarmType t, boolean isActive)
    {
        if (t==null)
            throw new IllegalArgumentException("invalid alarm type; null");

        this.isActive=isActive;
        this.type=t;
    }


    public boolean getIsActive() {
        return isActive;
    }

    public AlarmType getType() {
        return type;
    }

    public boolean isAlarmRinging(){
        return false; // todo some logic in here for different alarm types.
    }

}
