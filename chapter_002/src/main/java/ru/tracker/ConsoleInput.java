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
}
