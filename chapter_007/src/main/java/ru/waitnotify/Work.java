package ru.waitnotify;

/**
 * Created by nik on 6/6/2017.
 */
public class Work implements Runnable {
    @Override
    public void run() {
        System.out.println("doWork!");
    }
}
