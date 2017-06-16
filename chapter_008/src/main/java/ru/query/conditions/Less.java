package ru.query.conditions;

import ru.query.Fields;

/**
 * Created by nik on 6/16/2017.
 */
public class Less extends Condition {
    /**
     * Value for condition.
     */
    private String value;
    /**
     * Constructor.
     * @param field - field.
     * @param value - value.
     */
    public Less(Fields field, String value) {
        super(field);
        this.value = value;
    }
    @Override
    public String resultString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getField()).append(" < ").append(this.value);
        return sb.toString();
    }
}
