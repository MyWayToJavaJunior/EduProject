package ru.parsersqlru;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by nikolay on 31/07/17.
 */
public class MyTimer extends TimerTask {
    /**
     * Flag for stop threads.
     */
    private static volatile boolean flag = true;
    /**
     * Capacity of queue.
     */
    private static final int CAPACITY = 1000;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getRootLogger();
    /**
     * Nums of avalable procs.
     */
    private static final int N_THREADS = Runtime.getRuntime().availableProcessors();
    /**
     * Start parse.
     * @param lastParse - date of last parse.
     */
    private void startParse(Date lastParse) {
        final BlockingQueue<String> bq = new ArrayBlockingQueue<>(CAPACITY);
        final ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

        Runnable producer;
        producer = new Runnable() {
            public void run() {
                LinkParser linkParser = new LinkParser(bq, lastParse);
                linkParser.parse("http://www.sql.ru/forum/");

                while (true) {
                    if (bq.isEmpty()) {
                        flag = false;
                        executor.shutdown();
                        try {
                            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                                executor.shutdownNow();
                            }
                        } catch (InterruptedException e) {
                            LOGGER.error(e.getMessage());
                        }
                        break;
                    }
                }
            }
        };
        executor.execute(producer);

        Runnable consumer;
        for (int i = 0; i < N_THREADS; i++) {
            consumer = new Runnable() {
                public void run() {
                    WorkWithDB db = new WorkWithDB();
                    AdParser adParser = new AdParser(db);
                    do {
                        try {
                            adParser.parse(bq.take());
                        } catch (InterruptedException e) {
                            LOGGER.info("End of thread " + Thread.currentThread().getName());
                        }
                    } while (flag);
                }
            };
            executor.execute(consumer);
        }
    }
    /**
     * Write date of last parse to file.
     * @param path - path to file.
     */
    private void writeDate(String path) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(String.valueOf(new Date().getTime()));
            writer.append('\n');
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        Date lastParse = null;
        String path = "parser.data";

        File file = new File(path);
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    lastParse = new Date(Long.parseLong(s));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                writeDate(path);
            }
            writeDate(path);
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.fatal(e.getMessage());
            }
            writeDate(path);
        }

        startParse(lastParse);
    }
}
