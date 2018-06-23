package ru.sbt.collections;

import java.util.Iterator;
import java.util.List;

public class ReverseIterator <T> implements Iterator<T> {

    private int cursor;
    private int lastIndex;
    private List<T> list;

    // Конструктор
    public ReverseIterator(List list){
        this.list = list;
        this.lastIndex = list.size()-1;
        cursor = lastIndex;
    }

    @Override
    public boolean hasNext() {
        return cursor != 0;
    }

    @Override
    public T next() {
        return list.get(cursor--);
    }
}
