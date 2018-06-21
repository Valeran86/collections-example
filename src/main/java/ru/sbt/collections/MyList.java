package ru.sbt.collections;

import java.util.List;
import java.util.ListIterator;

public class MyList implements Iterable<String> {
    private List<String> stringList;
    private int sizeList;

    public MyList(List<String> stringList) {
        this.stringList=stringList;
        this.sizeList=stringList.size();
    }

    @Override
    public ListIterator<String> iterator() {
        ListIterator<String> lit = new ListIterator<String>() {

            private int index = sizeList-1;

            @Override
            public boolean hasNext() {
                return index < sizeList && (stringList.get(index) != null);
            }

            @Override
            public String next() {
                return stringList.get(index++);
            }

            @Override
            public boolean hasPrevious() {
                return index>=0 && index < sizeList && (stringList.get(index) != null);
            }

            @Override
            public String previous() {
                return stringList.get(index--);
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(String s) {

            }

            @Override
            public void add(String s) {

            }
        };
        return lit;
    }
}
