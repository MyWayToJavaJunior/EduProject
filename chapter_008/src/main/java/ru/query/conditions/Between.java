package ru.query.conditions;

import ru.query.Fields;

/**
 * Created by nik on 6/16/2017.
 */
public class Between extends Condition {
    /**
     * Begin of range in between.
     */
    private String valueFirst;
    /**
     * End of range in between.
     */
    private String valueLast;
    /**
     * Constructor.
     * @param field - field.
     * @param first - first.
     * @param last - last.
     */
    public Between(Fields field, String first, String last) {
        super(field);
        this.valueFirst = first;
        this.valueLast = last;
    }
    @Override
    public String resultString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getField()).append(" between ").append(this.valueFirst).append(" and ").append(this.valueLast);
        return sb.toString();
    }
}