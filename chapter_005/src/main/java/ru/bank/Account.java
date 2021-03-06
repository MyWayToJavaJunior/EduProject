package ru.bank;

/**
 * Created by nik on 4/7/2017.
 */
public class Account {
    /**
     * Ammout.
     */
    private double value;
    /**
     * requisites.
     */
    private long requisites;

    /**
     * Constructor.
     * @param value - ammout.
     * @param requisites - requisites.
     */
    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * requisites getter.
     * @return requisites.
     */
    public long getRequisites() {
        return this.requisites;
    }

    /**
     * value getter.
     * @return value.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * value setter.
     * @param value - value to set.
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Account tmp = (Account) obj;
        if (this.value == tmp.value && this.requisites == tmp.requisites) {
            return true;
        }
        return false;
    }
}
