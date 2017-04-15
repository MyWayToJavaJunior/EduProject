package ru.tracker;

import java.util.Scanner;

/**
 * Created by nik on 3/15/2017.
 */
public class ConsoleInput implements Input {
    /**
     * Scanner for input.
     */
    private Scanner  scanner = new Scanner(System.in);

    /**
     * ask question and get answer.
     * @param question - question.
     * @return - answer.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    /**
     * Range of answers.
     * @param question - question.
     * @param range - array of ranges.
     * @return - answer.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return  key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
