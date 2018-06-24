package ru.sbt.collections;

import java.util.Iterator;
import java.util.List;

class RevertIteratorList implements Iterable<String> {
    private List<String> stringList;
    private int sizeList;

    RevertIteratorList(List<String> stringList) {
        this.stringList=stringList;
        this.sizeList=stringList.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = sizeList-1;

            @Override
            public boolean hasNext() {
                return index>=0 && index < sizeList && (stringList.get(index) != null);
            }

            @Override
            public String next() {
                return stringList.get(index--);
            }
        };
    }
}
