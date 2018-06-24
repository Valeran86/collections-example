package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

// Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.

public class example03 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        String fileName = "/ru/sbt/collections/VeryBigText.txt";
        String lines = Counter1DifferentWords.getString(fileName);
        String [] words = lines.split("\\p{P}?[ \\t\\n\\r]+");

        // Коллекция хранит <Слово, Количество в тексте>
        HashMap<String, Integer> wordsCount = new HashMap<>();

        // Внесем слова в коллекцию wordsCount

        for (String word:  words) {
            wordsCount.merge(word, 1,Integer::sum);
        }

        // Выведем результат
        System.out.println(wordsCount.toString());

    }
}