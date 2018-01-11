package ru.eventcounter;

/**
 * Created by nikolay on 11/01/18.
 */
public interface ICounter {
    void addEvent(String event);
    long getCount(TUnit unit);
}
