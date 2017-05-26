package ru.synchronize;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by nik on 5/26/2017.
 */
public class TextSearcher implements Runnable {
    /**
     * Path to root directory.
     */
    private String path;
    /**
     * Word for search.
     */
    private String wordForSearch;
    /**
     * Flat, if true break all threads.
     */
    private boolean flag = false;
    /**
     * Constructor.
     * @param path - .
     * @param wordForSearch - .
     */
    public TextSearcher(String path, String wordForSearch) {
        this.path = path;
        this.wordForSearch = wordForSearch;
    }
    /**
     * Search in files.
     * @param f - file for search.
     * @throws IOException - .
     */
    private void searchFilesAndDirectoryes(File f) throws IOException {
        if (flag && !Thread.currentThread().isInterrupted()) {
            Thread.currentThread().interrupt();
        }
        if (!f.isDirectory()) {
            Scanner scanner = new Scanner(f);
            try {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    String[] cols = line.split(" ");

                    for (String s : cols) {
                        if (s.equals(this.wordForSearch)) {
                            System.out.println("Found iT in " + f.getName() + " " + Thread.currentThread().getName());
                            this.flag = true;
                            return;
                        }
                    }
                }

            } finally {
                scanner.close();
            }

        }

        if (f.isDirectory()) {
            try {
                File[] child = f.listFiles();
                for (int i = 0; i < child.length; i++) {
                    searchFilesAndDirectoryes(child[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            searchFilesAndDirectoryes(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Main met for tests.
     * @param args - 0 - path, 1 - word.
     */
    public static void main(String[] args) {
//        String path = "f:\\projects\\EduProject\\";
//        TextSearcher ts = new TextSearcher(path, "testMeNow");

        String path = args[0]; //path to begin point.
        String name = args[1]; // word for search.
        TextSearcher ts = new TextSearcher(path, name);

        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
