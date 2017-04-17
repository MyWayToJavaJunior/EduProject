package ru.iterators;

import java.util.Iterator;

/**
 * Created by nik on 4/17/2017.
 */
public class ConverterIters implements ConvertIterators {

    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

            return new Iterator<Integer>() {

            private Iterator<Integer> curIter = null;

            @Override
            public boolean hasNext() {
                getCurIter();
                return (curIter != null && curIter.hasNext());
            }

            @Override
            public Integer next() {
                getCurIter();
                if (curIter == null) {
                    return null;
                }
                return curIter.next();
            }

            private void getCurIter() {
                if (curIter != null && curIter.hasNext()) {
                    return;
                }
                while (it.hasNext()) {
                    Iterator<Integer> nextIterator = it.next();
                    if (nextIterator.hasNext()) {
                        curIter = nextIterator;
                        break;
                    }
                }
            }
        };
    }
}
