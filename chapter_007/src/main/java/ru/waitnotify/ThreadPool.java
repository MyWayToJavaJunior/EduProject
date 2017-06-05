package ru.waitnotify;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by nik on 5/29/2017.
 */
public class ThreadPool {
    static class Work implements Runnable {
        public void work() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " is live.");
            Random random = new Random();
            int r = random.nextInt(2500);
            Thread.sleep(r);
        }

        @Override
        public void run() {
            try {
                this.work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //private SynchronousQueue<Thread> queue = new SynchronousQueue<>();

    int proc = Runtime.getRuntime().availableProcessors();
    BlockingQueue<Thread> lq = new LinkedBlockingQueue<>(proc);
    ExecutorService executor = Executors.newFixedThreadPool(proc);

    void add(Work work) throws InterruptedException {
        lq.put(new Thread(work));
    }

    public static void main(String[] args) {
        ThreadPool pt = new ThreadPool();

        for (int i = 0; i < 20; i++) {
            pt.executor.execute(new Work());
        }
        pt.executor.shutdown();
    }
}
