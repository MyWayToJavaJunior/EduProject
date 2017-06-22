package ru.bomber2;

/**
 * Created by nik on 6/22/2017.
 */
public class StartGame {

    public static void main(String[] args) {
        Board b = new Board(10, 2);
        new Thread(new Monster(new Cell(5,5),b)).start();
        new Thread(new Monster(new Cell(4,5),b)).start();
        new Thread(new Hero(new Cell(1,2),b)).start();
    }
}
