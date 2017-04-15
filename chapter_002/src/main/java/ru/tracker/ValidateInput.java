package ru.tracker;

/**
 * Created by nik on 3/24/2017.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Range of answers.
     * @param question - question.
     * @param range - array of ranges.
     * @return - answer.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data. ");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu. ");
            }
        } while (invalid);
        return value;
    }
}
