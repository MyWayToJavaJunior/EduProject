package ru.nonblockingalgo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nik on 6/7/2017.
 */
public class Cache {
    /**
     * cache of models.
     */
     private ConcurrentHashMap<String, Model> cache = new ConcurrentHashMap<>();
    /**
     * Add to cache.
     * @param key - name of model.
     * @param model - model.
     */
    public void add(String key, Model model) {
        cache.put(key, model);
    }
    /**
     * Update model.
     * @param name - name of model.
     */
    public void update(String name) {
        int startVer = cache.get(name).getVersion();

        cache.computeIfPresent(name, (k, v) -> {
            if (startVer != v.getVersion()) {
                throw new OplimisticException("Oplimistic exception.");
            }
            return v.incMod();
        });

    }
    /**
     * Delete model.
     * @param name - name of model.
     */
    public void delete(String name) {
        cache.remove(name);
    }
    /**
     * Print version.
     * @param name - name of model.
     * @return - version.
     */
    public int print(String name) {
        return cache.get(name).getVersion();
    }
    /**
     * Main controller method.
     * @param args - .
     */
    public static void main(String[] args) {
        Cache c = new Cache();
        c.add("first", new Model("first"));
        c.add("second", new Model("second"));
        c.add("third", new Model("third"));

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    c.update("first");
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(c.print("first"));
    }
}
