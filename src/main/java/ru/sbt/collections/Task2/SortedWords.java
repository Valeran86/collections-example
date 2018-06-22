package ru.sbt.collections.Task2;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
 */
public class SortedWords {
    public static void main(String[] args) throws IOException, URISyntaxException {
        InputStream resourceAsStream = SortedWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String text = IOUtils.toString(resourceAsStream, "UTF8");
        String[] words = text.split("[ -_—,.;:?!\n\r\t\'\"]");
        TreeSet<String> set = new TreeSet<>((s1, s2) -> {
            int difference = s1.length() - s2.length();
            if (difference == 0) {
                if (s1.equals(s2))
                    return 0;
                return 1;
            }
            return difference;
        });
        for (String word : words) {
            if (set.contains(word))
                continue;
            set.add(word);
        }

        for (String word : set) {
            System.out.println(word);
        }
        System.out.println("Всего различных слов: " + set.size());
    }
}
