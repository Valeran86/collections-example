package ru.sbt.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
    public static String[] lines2words(String lines) {
        return lines.split("[^a-zA-Zа-яА-Я,.]+");
    }

    public static Set<String> words2set(List<String> items){
        Set<String> set = new HashSet<String>(items);
        for (String item : items) {
            set.add(item);
        }
        return set;
    }
}
