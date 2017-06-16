package ru.query.conditions;

import ru.query.Fields;

import java.util.List;

/**
 * Created by nik on 6/16/2017.
 */
public class On extends Condition {
    /**
     * List of values in ON condition.
     */
    private List<String> list;
    /**
     * Constructor.
     * @param field - field.
     * @param list - list.
     */
    public On(Fields field, List<String> list) {
        super(field);
        this.list = list;
    }
    @Override
    public String resultString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getField()).append(" on(");
        for (String s : list) {
            sb.append(s).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
