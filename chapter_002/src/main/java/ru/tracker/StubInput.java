package ru.tracker;

/**
 * Created by nik on 3/16/2017.
 */
public class StubInput implements Input {
    /**
     * array of answers.
     */
    private  String[] answers;
    /**
     * counter.
     */
    private int position = 0;

    /**
     * constructor.
     * @param answers - array of answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * ask.
     * @param question - question.
     * @return - answer.
     */
    public String ask(String question) {
        return answers[position++];
    }
}
