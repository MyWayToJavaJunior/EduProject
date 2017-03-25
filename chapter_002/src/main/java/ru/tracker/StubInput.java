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