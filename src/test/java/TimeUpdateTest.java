package test;

import core.time.TimeUpdate;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ed on 15/03/14.
 */
public class TimeUpdateTest {

    private final double epsilon = 1*Math.pow(10, -6);

    @Test
    public void testGetDate() throws Exception {
        Date d = new Date();

        assertEquals(d, new TimeUpdate(d).getDate());
    }

    @Test
    public void testHrsDiffFrom() throws Exception {

        Calendar c = Calendar.getInstance();
        c.clear();

        c.set(Calendar.HOUR_OF_DAY, 10);

        Date d1 = c.getTime();

        c.set(Calendar.HOUR_OF_DAY, 11);

        Date d2 = c.getTime();

        assertEquals(1.0, new TimeUpdate(d1).hrsDiffFrom(new TimeUpdate(d2)));
        assertEquals(1.0, new TimeUpdate(d2).hrsDiffFrom(new TimeUpdate(d1)));
        assertEquals(0.0, new TimeUpdate(d1).hrsDiffFrom(new TimeUpdate(d1)));


        c.set(Calendar.MINUTE, 30);
        d2 = c.getTime();

        assertEquals(1.5, new TimeUpdate(d1).hrsDiffFrom(new TimeUpdate(d2)) );

    }

    @Test
    public void testMsToHrs()  throws Exception {

        assertEquals(0.0277778, TimeUpdate.msToHrs(100000), epsilon);

    }
}
