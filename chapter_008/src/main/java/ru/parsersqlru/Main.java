package ru.parsersqlru;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nikolay on 20/07/17.
 */
public class Main {
    /**
     * Main.
     * @param args - args.
     * @throws IOException - .
     */
    public static void main(String[] args) throws IOException {
        long minutes = 3;
        long secFactor = 60000;
        TimerTask task = new MyTimer();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, minutes * secFactor);
    }
}
