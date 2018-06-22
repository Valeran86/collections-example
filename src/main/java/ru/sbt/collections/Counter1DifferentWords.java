package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        int i = 0;
        InputStream resourceAsStream = Counter3DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString(resourceAsStream, "UTF8");

        Pattern pattern = Pattern.compile("[\n\t,.!?;: ]");
        ArrayList<String> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();

        for (String temp : pattern.split(lines)) {
            al.add(temp);
            hs.add(temp);
        }

        System.out.println("\n" + "количество уникальных слов " + hs.size() + "/общее количество слов с повторениями " + al.size());
    }
}


