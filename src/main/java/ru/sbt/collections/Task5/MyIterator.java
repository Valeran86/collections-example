package ru.sbt.collections.Task5;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
 */
class MyIterator<T> implements Iterator<T> {
    private int index;
    private List<T> collection;

    public MyIterator(List<T> collection) {
        index = collection.size();
        this.collection = collection;
    }

    public T next(){
        return this.collection[0];
    }

    public boolean hasNext(){

    }

    public void remove(){

    }
}
