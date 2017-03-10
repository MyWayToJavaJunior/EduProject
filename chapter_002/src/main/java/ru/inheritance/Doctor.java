package ru.inheritance;

/**
 * Created by nik on 3/10/2017.
 */
public class Doctor extends Profession {
    /**
     * workProfile of doctor.
     */
    private String workProfile;

    /**
     * constructor.
     * @param name - name of doctor.
     * @param diploma - diploma of doctor.
     * @param exp - experience of doctor.
     * @param work - workProfile of doctor.
     */
    public Doctor(String name, String diploma, int exp, String work) {
        super(name, diploma, exp);
        this.workProfile = work;
    }

    /**
     * Getter.
     * @return workProfile.
     */
    public String getWorkProfile() {
        return this.workProfile;
    }

    /**
     * Heal.
     */
    public void heal() {
    }

    /**
     * writeOutPills.
     * @return pills.
     */
    public String writeOutPills() {
        return "Pillz";
    }
}
