package ru.sbt.collections.Task3;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class CountUses {
    public static void main(String[] args) throws IOException, URISyntaxException {
        InputStream resourceAsStream = CountUses.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String text = IOUtils.toString(resourceAsStream, "UTF8");
        String[] words = text.split("[ -_—,.;:?!\n\r\t\'\"]");
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            if (hm.containsKey(word))
                hm.put(word, hm.get(word) + 1);
            else
                hm.put(word, 1);
        }

        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (e.getValue() > 1)
                System.out.println(e);
        }
        System.out.println("Всего различных слов: " + hm.size());
    }
}
