package ru.sbt.collections;

import java.util.Iterator;
import java.util.List;

public class ReverseIterator <T> implements Iterator<T> {

    private int cursor;
    private List<T> list;

    // Конструктор
    public ReverseIterator(List list){
        this.list = list;
        cursor = list.size()-1;

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
