package ru.eventcounter;

import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikolay on 11/01/18.
 */
public class Counter implements ICounter {
    private static final long MINUTE_IN_MILLIS = 60 * 1000;
    private static final long HOUR_IN_MILLIS = 60 * 60 * 1000;
    private static final long DAY_IN_MILLIS = 60 * 60 * 24 * 1000;

    private Map<Integer, EventWrapper> map = new ConcurrentSkipListMap<>();

    private AtomicInteger counter = new AtomicInteger(Integer.MAX_VALUE);

    private class EventWrapper {
        private String event;
        private Timestamp timestamp;

        private EventWrapper(String event, Timestamp timestamp) {
            this.event = event;
            this.timestamp = timestamp;
        }
    }

    @Override
    public void addEvent(String event) {
        map.put(counter.decrementAndGet(),
                new EventWrapper(event, new Timestamp(System.currentTimeMillis())));
    }

    @Override
    public long getCount(TUnit unit) {
        long result = 0;
        switch (unit) {
            case MIN: result = calculate(MINUTE_IN_MILLIS);
                break;
            case HOUR: result = calculate(HOUR_IN_MILLIS);
                break;
            case DAY: result = calculate(DAY_IN_MILLIS);
                break;
        }
        return result;
    }

    private long calculate(long interval) {
        int count = 0;
        for(Map.Entry<Integer, EventWrapper> entry : map.entrySet()) {
            if (entry.getValue().timestamp.after(new Timestamp(System.currentTimeMillis() - interval))) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
