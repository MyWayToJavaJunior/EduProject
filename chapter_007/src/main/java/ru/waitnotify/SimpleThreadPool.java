package ru.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 5/29/2017.
 */
public class SimpleThreadPool {
    /**
     * Created by nik on 5/29/2017.
     */
    class PoolThread extends Thread {
        /**
         * Queue of tasks.
         */
        private SimpleBlockingQueue taskQueue = null;
        /**
         * is stopped flag.
         */
        private boolean isStopped = false;
        /**
         * Constructor.
         * @param queue - queue of tasks.
         */
        PoolThread(SimpleBlockingQueue queue) {
            taskQueue = queue;
        }
        @Override
        public void run() {
            while (!isStopped()) {
                try {
                    Runnable runnable = (Runnable) taskQueue.get();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * Stop pool.
         */
        public synchronized void doStop() {
            isStopped = true;
            this.interrupt();
        }
        /**
         * is stopped ?
         * @return isStopped.
         */
        public synchronized boolean isStopped() {
            return isStopped;
        }
    }
    /**
     * No of procs.
     */
    private int proc = Runtime.getRuntime().availableProcessors();
    /**
     * queue of tasks.
     */
    private SimpleBlockingQueue taskQueue = null;
    /**
     * list of threads.
     */
    private List<PoolThread> threads = new ArrayList<>();
    /**
     * is stopped flag.
     */
    private boolean isStopped = false;
    /**
     * Constructor.
     */
    SimpleThreadPool() {
        taskQueue = new SimpleBlockingQueue();

        for (int i = 0; i < this.proc; i++) {
            threads.add(new PoolThread(taskQueue));
        }
        for (PoolThread thread : threads) {
            thread.start();
        }
    }

//    public synchronized void execute(Runnable task) throws Exception{
//        if(this.isStopped) throw
//                new IllegalStateException("ThreadPool is stopped");
//
//        this.taskQueue.put(task);
//    }
    /**
     * stop the pool.
     */
    public synchronized void stop() {
        this.isStopped = true;
        for (PoolThread thread : threads) {
            thread.doStop();
        }
    }
    /**
     * add work.
     * @param work - work.
     * @throws Exception - .
     */
    public synchronized void add(Work work) throws Exception {
        this.taskQueue.put(work);
    }
    /**
     * Test main method.
     * @param args - .
     */
    public static void main(String[] args) {
        SimpleThreadPool pt = new SimpleThreadPool();
        for (int i = 0; i < 100; i++) {
            try {
                pt.add(new Work());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pt.stop();
    }
}
