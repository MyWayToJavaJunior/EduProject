package ru.jmm;

/**
 * Created by nik on 5/24/2017.
 */
public class Record {
    /**
     * shared var.
     */
    private int x = 10;
    /**
     * If var sync must return 10, if not maybe somethink else.
     */
    public void writer() {
        x -= 1;
        x += 1;
        System.out.println("x = " + x);
    }

}
