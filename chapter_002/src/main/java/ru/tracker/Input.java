package ru.tracker;

/**
 * Created by nik on 3/15/2017.
 */
public interface Input {
    /**
     * ask question and get answer.
     * @param question - question.
     * @return - answer.
     */
    String ask(String question);
    /**
     * Range of answers.
     * @param question - question.
     * @param range - array of ranges.
     * @return - answer.
     */
    int ask(String question, int[] range);
}
