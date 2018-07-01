package ru.sbt.collections;

import java.util.Iterator;
import java.util.List;

/**
 * Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
 */
public class ExoticIterator<T> implements Iterator<T> {
    private int index;
    private List<T> list;

    public ExoticIterator(List<T> list) {
        index = list.size() - 1;
        this.list = list;
    }

    @Override
    public T next() {
        return this.list.get(index--);
    }

    @Override
    public boolean hasNext() {
        return index > -1;
    }
}
