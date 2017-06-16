package ru.query;

import ru.query.conditions.Condition;
import java.util.List;

/**
 * Created by nik on 6/16/2017.
 */
public class QueryBuilder {
    /**
     * Conditions between simple condition.
     */
    enum MultiCondition {
        /**
         * and.
         */
        and,
        /**
         * or.
         */
        or
    }
    /**
     * list of fields in query.
     */
    private List<Fields> f;
    /**
     * list of Conditions in query.
     */
    private List<Condition> c;
    /**
     * list of conditions between conditions in query.
     */
    private List<MultiCondition> m;
    /**
     * Constructor.
     * @param c - conditions.
     * @param f - fields.
     * @param m - multi conditions.
     */
    public QueryBuilder(List<Fields> f, List<Condition> c, List<MultiCondition> m) {
        this.f = f;
        this.c = c;
        this.m = m;
    }
    /**
     * Create result query.
     * @return - result query.
     */
    public String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        if (f.contains(Fields.all)) {
            sb.append(" * ");
        } else {
            for (Fields fields : f) {
                sb.append(fields).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        }

        sb.append(" from items where ");
        int index = 0;
        for (Condition con : c) {
            sb.append(con.resultString());
            if (index < m.size()) {
                sb.append(" ").append(m.get(index).toString()).append(" ");
                index++;
            }
        }

        return sb.toString();
    }

//    public static void main(String[] args) {
//        QueryBuilder qb = new QueryBuilder(Arrays.asList(Fields.name_item, Fields.create_date, Fields.all),
//                                           Arrays.asList(new Between(Fields.name_item, "q", "w"), new Equal(Fields.create_date, "2000-3-4")),
//                                           Arrays.asList(MultiCondition.and));
//        qb.create();
//    }
}
