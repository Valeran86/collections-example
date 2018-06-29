package ru.sbt.collections;

import java.util.ArrayList;

public interface ReverseIterator {
    int cursor = 0;
    public boolean hasPrevious();
    public String previous();

}
