package ru.sbt.collections;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

//Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
public class SortedListOfUniqueWords {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        String[] words = Reader.read();
        TreeSet<String> unique = new TreeSet<>(new AlphabeticalOrderComparator());
        for (String word :words) {
            unique.add(word);
        }

        for (String word: unique) {
            System.out.println(word);
        }
    }
    static class AlphabeticalOrderComparator implements Comparator<String> {
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        }
    }
}
