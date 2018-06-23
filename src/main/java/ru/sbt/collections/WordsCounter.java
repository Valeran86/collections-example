package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
//Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
public class WordsCounter {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        String[] words = Reader.readWords();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word: words) {
            map.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
