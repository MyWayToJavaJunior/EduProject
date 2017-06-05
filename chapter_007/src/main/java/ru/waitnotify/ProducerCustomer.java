package ru.waitnotify;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by nik on 5/29/2017.
 */
public class ProducerCustomer {
    /**
     * Sync queue.
     */
    private SynchronousQueue<String> queue = new SynchronousQueue<>();
    /**
     * Main met.
     * @param args - .
     */
    public static void main(String[] args) {
        ProducerCustomer pc = new ProducerCustomer();

        new Thread("producer") {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        String event = new Integer(i).toString();
                        pc.queue.put(event);
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
                        String event = pc.queue.take();
                        System.out.println("Customer in " + Thread.currentThread().getName() + " get " + event);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

