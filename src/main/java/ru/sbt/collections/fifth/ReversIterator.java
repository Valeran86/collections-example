package ru.sbt.collections.fifth;

import java.util.*;

public class ReversIterator<T> implements Iterable<T> {

    private T[] arrayList;
    private int currentSize;

    public ReversIterator( T[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = currentSize-1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0 && arrayList[currentIndex] != null;
            }

            @Override
            public T next() {
                return arrayList[currentIndex--];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
        return it;
    }
}
