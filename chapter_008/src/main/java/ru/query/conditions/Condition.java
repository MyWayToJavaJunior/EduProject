package ru.query.conditions;

import ru.query.Fields;

/**
 * Created by nik on 6/16/2017.
 */
public abstract class Condition {
    /**
     * Field for condition.
     */
    private String field;
    /**
     * Constructor.
     * @param field - field.
     */
    public Condition(Fields field) {
        this.field = field.toString();
    }
    /**
     * Generate string with simple condition.
     * @return - string with condition.
     */
    public abstract String resultString();
    /**
     * Field getter.
     * @return - field.
     */
    public String getField() {
        return this.field;
    }
}
