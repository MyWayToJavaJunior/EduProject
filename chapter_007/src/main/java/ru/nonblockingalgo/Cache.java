package ru.nonblockingalgo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nik on 6/7/2017.
 */
public class Cache {
     ConcurrentHashMap<String, Model> cache = new ConcurrentHashMap<>();

    public void add(String key, Model model) {
        cache.put(key, model);
    }

    public void update(String name) {
        int startVer = cache.get(name).getVersion();

        //doSomeThing.

        int curVer = cache.get(name).getVersion();

        if (startVer != curVer) {
            throw new OplimisticException("Oplimistic exception.");
        }

        cache.computeIfPresent(name, (k,v) -> v.incMod());

    }

    public void delete(String name) {
        cache.remove(name);
    }

    public int print(String name) {
        return cache.get(name).getVersion();
    }

    public static void main(String[] args) {
        Cache c = new Cache();
        c.add("first", new Model("first"));
        c.add("second", new Model("second"));
        c.add("third", new Model("third"));

        for (int i = 0; i < 100; i++) {
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
