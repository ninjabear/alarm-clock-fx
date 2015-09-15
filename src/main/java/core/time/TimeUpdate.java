package core.time;

import java.util.Date;

/**
 * Created by Ed on 15/03/14.
 */
public class TimeUpdate {

    private final Date d;

    public TimeUpdate(Date d)
    {
        this.d=d;
    }

    public Date getDate() { return d; }

    public double hrsDiffFrom(final TimeUpdate t)
    {
        if (t==null)
            throw new IllegalArgumentException("hrs diff; cannot diff null");

        long min,max;

        max = Math.max(t.getDate().getTime(), d.getTime());
        min = Math.min(t.getDate().getTime(), d.getTime());

        long diffms = max-min;

        return msToHrs(diffms);
    }

    public static double msToHrs(final long ms)
    {
        long seconds = ms / 1000;
        double hours = seconds / 3600.00; // 60*60
        return hours;
    }

}
