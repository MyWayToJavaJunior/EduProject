package ru.inheritance;

/**
 * Created by nik on 3/10/2017.
 */
public class Engineer extends Profession {
    /**
     * lineOfWork of engineer.
     */
    private String lineOfWork;

    /**
     * constructor.
     * @param name - name of doctor.
     * @param diploma - diploma of doctor.
     * @param exp - experience of doctor.
     * @param line - lineOfWork of doctor.
     */
    public Engineer(String name, String diploma, int exp, String line) {
        super(name, diploma, exp);
        this.lineOfWork = line;
    }

    /**
     * Getter.
     * @return lineOfWork.
     */
    public String getLineOfWork() {
        return this.lineOfWork;
    }

    /**
     * Program.
     */
    public void program() {
    }

    /**
     * Design.
     */
    public void design() {
    }
}
