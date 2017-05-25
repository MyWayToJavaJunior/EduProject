package ru.synchronize;

/**
 * Created by nik on 5/25/2017.
 */
public class Count implements Runnable {
    /**
     * value for inc.
     */
    private int value = 0;
    /**
     * increment met.
     * @return inc value.
     */
    public synchronized int incremant() {
        System.out.println(++this.value);
        return this.value;
    }

    @Override
    public void run() {
            this.incremant();
    }
    /**
     * main met.
     * @param args -
     */
    public static void main(String[] args) {
        Count c = new Count();

        for (int i = 0; i < 10; i++) {
            new Thread(c).start();
            new Thread(c).start();
        }
    }
}
