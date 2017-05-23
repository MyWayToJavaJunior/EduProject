package ru.threads;

/**
 * Created by nik on 5/23/2017.
 */
public class SpaceCounter {
    /**
     * Counter for spaces.
     */
    static final class Space extends AbstractCounter {
        /**
         * Constructor.
         * @param text - text for count.
         */
        Space(String text) {
            super(text);
        }

        @Override
        int counter() {
            int result = 0;
            for (int i = 0; i < this.getText().length; i++) {
                if (this.getText()[i] == ' ') {
                    result++;
                }
            }
            return result;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(2);
                System.out.println("Spaces = " + counter());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Counter for words.
     */
    static final class Word extends AbstractCounter {
        /**
         * Constructor.
         * @param text - text for count.
         */
        Word(String text) {
            super(text);
        }

        @Override
        int counter() {
            int result = 0;
            if (this.getText()[0] != ' ') {
                result++;
            }
            for (int i = 0; i < this.getText().length - 1; i++) {
                if (this.getText()[i] == ' ' && this.getText()[i + 1] != ' ') {
                    result++;
                }
            }
            return result;
        }

        @Override
        public void run() {
            System.out.println("Words = " + counter());
        }
    }
}
