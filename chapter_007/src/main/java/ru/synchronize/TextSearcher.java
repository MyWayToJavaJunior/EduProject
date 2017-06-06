package ru.synchronize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nik on 5/26/2017.
 */
public class TextSearcher {
    /**
     * Created by nik on 5/26/2017.
     */
    static class ParseFile implements Runnable {
        /**
         * Flag, if true break all threads.
         */
        private boolean flag = false;
        /**
         * text for search.
         */
        private String name;
        /**
         * Path to file.
         */
        private String path;
        /**
         * Constructor.
         * @param path - path to file.
         * @param name - text to search.
         */
        ParseFile(String path, String name) {
            this.name = name;
            this.path = path;
        }
        /**
         * Search text in file.
         * @param f - file for seatch.
         * @throws FileNotFoundException -.
         */
        private void search(File f) throws FileNotFoundException {
            if (flag && !Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
            }
            Scanner scanner = new Scanner(f);
            try {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    String[] cols = line.split(" ");

                    for (String s : cols) {
                        if (s.equals(this.name)) {
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

        @Override
        public void run() {
            try {
                search(new File(this.path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Path to root directory.
     */
    private String path;
    /**
     * Word for search.
     */
    private String wordForSearch;
    /**
     * Set of files.
     */
    private Set<String> set = new HashSet<>();

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
     * Set getter.
     * @return set of files.
     */
    public Set<String> getSet() {
        return set;
    }

    /**
     * Search in files.
     * @param f - file for search.
     * @throws IOException - .
     */
    public void searchFilesAndDirectoryes(File f) throws IOException {
        if (!f.isDirectory()) {
            this.set.add(f.getPath());
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

    /**
     * Main met for tests.
     * @param args - 0 - path, 1 - word.
     */
    public static void main(String[] args) {
//        String path = "f:\\projects\\EduProject\\";
//        TextSearcher ts = new TextSearcher(path, "testMeNow");
        int proc = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(proc);
        String path = args[0]; //path to begin point.
        String name = args[1]; // word for search.
        TextSearcher ts = new TextSearcher(path, name);
        try {
            ts.searchFilesAndDirectoryes(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> set = ts.getSet();
        for (String s : set) {
            executor.execute(new ParseFile(s, name));
        }
        executor.shutdown();
    }
}
