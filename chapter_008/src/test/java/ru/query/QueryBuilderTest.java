package ru.query;

import org.junit.Test;
import ru.query.conditions.Between;
import ru.query.conditions.Equal;

import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 6/16/2017.
 */
public class QueryBuilderTest {
    /**
     * Test sql generator.
     */
    @Test
    public void whenThen() {
        QueryBuilder qb = new QueryBuilder(Arrays.asList(Fields.name_item, Fields.create_date, Fields.all),
                                           Arrays.asList(new Between(Fields.name_item, "q", "w"), new Equal(Fields.create_date, "2000-3-4")),
                                           Arrays.asList(QueryBuilder.MultiCondition.and));
        String result = qb.create();
        String testData = "select  *  from items where name_item between q and w and create_date = 2000-3-4";
        assertThat(testData, is(result));
    }
}
