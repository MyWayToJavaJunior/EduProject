package ru.tracker;

/**
 * Created by nik on 3/16/2017.
 */
public class ConsoleOutput implements Output {
    /**
     * print 1 item.
     * @param i - item.
     */
    public void print(Item i) {
        System.out.println(i.getId() + " " + i.getName() + " " + i.getDesc());
    }

    /**
     * print array of  items.
     * @param mas - array of item.
     */
    public void print(Item[] mas) {
        for (Item i : mas) {
            System.out.println(i.getId() + " " + i.getName() + " " + i.getDesc());
        }
    }
}
