package ru.sbt.collections.Task1;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String text = IOUtils.toString( resourceAsStream, "UTF8" );
        String[] words = text.split("[ -_—,.;:?!\n\r\t\'\"]");
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            if(set.contains(word))
                continue;
            set.add(word);
        }

        System.out.println("Всего различных слов: " + set.size());
    }
}
