package ru.utils;

import java.time.format.DateTimeFormatter;

/**
 * Created by nikolay on 08/11/17.
 */
public class TimeUtil {
    public static DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
