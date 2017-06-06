package ru.waitnotify;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nik on 6/6/2017.
 * @param <T> - type of items.
 */
public class SimpleBlockingQueue<T> {
    /**
     * queue of threads.
     */
    private List<T> queue = new LinkedList<>();
    /**
     * limit of threads in queue.
     */
    private int  limit;
    /**
     * Default conctructor.
     */
    SimpleBlockingQueue() {
        this.limit = 4;
    }
    /**
     * Constructor.
     * @param limit - limit of threads in queue.
     */
    SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }
    /**
     * Put item to queue.
     * @param item - item.
     * @throws InterruptedException - .
     */
    public synchronized void put(T item)
            throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }
    /**
     * Get item from queue.
     * @return - item.
     * @throws InterruptedException - .
     */
    public synchronized T get()
            throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
    /**
     * Test method.
     * @param args - .
     */
    public static void main(String[] args) {
        SimpleBlockingQueue<String> bq = new SimpleBlockingQueue<>(3);

        new Thread("producer") {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        String event = new Integer(i).toString();
                        bq.put(event);
                        System.out.println("Producer in " + Thread.currentThread().getName() + " put " + event);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("customer") {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        String event = bq.get();
                        System.out.println("Customer in " + Thread.currentThread().getName() + " get " + event);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
