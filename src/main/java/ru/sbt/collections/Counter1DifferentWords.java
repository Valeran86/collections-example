package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashSet;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );
        String[] words = lines.split("[\n\r .,()]");
        HashSet<String> unique = new HashSet<>();
        for (String word :words) {
                unique.add(word);
        }

        System.out.println(unique.size());
    }
}
