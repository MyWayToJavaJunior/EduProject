package ru.inheritance;

/**
 * Created by nik on 3/10/2017.
 */
public class Teacher extends Profession {
    /**
     * subject of teacher.
     */
    private String subject;

    /**
     * constructor.
     * @param name - name of teacher.
     * @param diploma - diploma of teacher.
     * @param exp - experience of teacher.
     * @param subj - subject of teacher.
     */
    public Teacher(String name, String diploma, int exp, String subj) {
        super(name, diploma, exp);
        this.subject = subj;
    }

    /**
     * Getter.
     * @return subject.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Teach.
     */
    public void teach() {
    }

    /**
     * Evaluate.
     * @return mark.
     */
    public int evaluate() {
        return 5;
    }
}
