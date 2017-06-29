package ru.bomber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nik on 6/22/2017.
 */
public class StartGame {

    private static final int MONSTERS = 2;

    public static void main(String[] args) {
        Board b = new Board(10, 4);

        ExecutorService executor = Executors.newFixedThreadPool(MONSTERS);
        executor.submit(new Monster(new Cell(5,5),b));
        executor.submit(new Monster(new Cell(4,5),b));

    }
}
