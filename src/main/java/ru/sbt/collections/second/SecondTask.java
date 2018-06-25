package ru.sbt.collections.second;

import ru.sbt.collections.first.FirstTask;
import java.util.*;

public class SecondTask extends FirstTask {
    String[] wordsArray;

    public SecondTask(String[] words){
        super(words);
        this.wordsArray = words;
    }

    public void getSortedArrayWordsToLength()
    {
        List<String> words = new ArrayList<>();
        Collections.addAll(words, this.wordsArray);
        Comparator<String> wordsSorter = (word1, word2) -> word1.length() - word2.length();
        //первый .sorted() сортирует еще и по алфавиту, второй по условию
        words.stream().sorted().sorted(wordsSorter).forEach(System.out::println);
    }
}
