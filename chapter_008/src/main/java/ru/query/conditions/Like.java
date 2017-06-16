package ru.query.conditions;

import ru.query.Fields;

/**
 * Created by nik on 6/16/2017.
 */
public class Like extends Condition {
    /**
     * Value for condition.
     */
    private String value;
    /**
     * Constructor.
     * @param field - field.
     * @param value - value.
     */
    public Like(Fields field, String value) {
        super(field);
        this.value = value;
    }
    @Override
    public String resultString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getField()).append(" like '%").append(this.value).append("%'");
        return sb.toString();
    }
}
