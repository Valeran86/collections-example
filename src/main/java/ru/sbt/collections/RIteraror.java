package ru.sbt.collections;

import java.util.ArrayList;

public class RIteraror implements ReverseIterator{
    Integer cursor;
    ArrayList<String> list;

    public RIteraror(ArrayList<String> list) {
        this.list=list;
        cursor = list.size()-1;
    }
    public boolean hasPrevious() {
        return cursor>-1;
    }

    public String previous() {
        int i = cursor;
        String previousElement=list.get(cursor);
        cursor = i - 1;
        return previousElement;

    }
}
