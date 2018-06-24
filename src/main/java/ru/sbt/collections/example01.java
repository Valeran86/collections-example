package ru.sbt.collections;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;

// Задание 1: Подсчитайте количество различных слов в файле.
public class example01 {
    public static void main( String[] args ) throws IOException, URISyntaxException {

        String fileName = "/ru/sbt/collections/VeryBigText.txt";

        String lines = Counter1DifferentWords.getString(fileName);

        String [] words = lines.split("\\p{P}?[ \\t\\n\\r]+");
        System.out.println("Всего слов = " + words.length);
        HashSet<String> hashSet = new HashSet(Arrays.asList(words));

        System.out.println("Различных слов = " + hashSet.size());

    }
}