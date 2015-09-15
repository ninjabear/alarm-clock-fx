package core.time;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ed on 15/03/14.
 */
public class Timer {

    private List<WeakReference<TimeListener>> listeners = new ArrayList<WeakReference<TimeListener>>();
    private final Object listenerLock = new Object();

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Timer() {
        this(null);
    }

    public Timer(TimeListener t) {
        if (t != null) {
            addTimeListener(t);
        }

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                pushTimerUpdate(new TimeUpdate(new Date()));
            }
        },
        0,
        1,
        TimeUnit.SECONDS);

    }


    private void pushTimerUpdate(TimeUpdate t) {
        if (t == null)
            throw new IllegalArgumentException("time update null");

        cleanupListeners();

        synchronized (listenerLock) {
            for (WeakReference<TimeListener> l : listeners) {
                if (l != null && l.get() != null) {
                    l.get().update(t);
                }
            }
        }

    }

    private void cleanupListeners() {
        synchronized (listenerLock) {
            ArrayList<Integer> todel = new ArrayList<>();

            for (int i = 0; i < listeners.size(); i++) {
                if (listeners.get(i) == null || listeners.get(i).get() == null)
                    todel.add(i);
            }


            for (int idx : todel)
                listeners.remove(idx);
        }
    }

    private void removeTimeListener(TimeListener t) {

        cleanupListeners();

        synchronized (listenerLock) {
            ArrayList<Integer> todel = new ArrayList<>();

            for (int i = 0; i < listeners.size(); i++) {
                if (listeners.get(i) != null && listeners.get(i).get() != null) {
                    if (listeners.get(i).get() == t) {
                        todel.add(i);
                    }
                }
            }

            for (int idx : todel) {
                listeners.remove(idx);
            }
        }

    }


    public void addTimeListener(TimeListener t) {
        if (t == null)
            throw new IllegalArgumentException("cannot add null listener");

        cleanupListeners();

        synchronized (listenerLock) {
            listeners.add(new WeakReference<TimeListener>(t));
        }
    }


}
