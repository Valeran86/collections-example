package ru.sbt.collections;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ReverseList implements Iterable<String> {
    private List<String> list;
    private int position;

    public ReverseList( List<String> list ) {
        this.list = list;
        position = list.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return ( position >= 0 );
            }

            @Override
            public String next() {
                if ( position < 0 )
                    throw new NoSuchElementException( "Элемент не найден" );
                return list.get( position-- );
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException( "no changes allowed" );
            }
        };
    }
}