package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
//Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
public class WordsCounter {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        String[] words = Reader.read();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            }
            else {
                map.put(word, 1);
            }
        }
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
