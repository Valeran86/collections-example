package ru.sbt.collections.second;

import ru.sbt.collections.first.FirstTask;

import java.util.*;

public class SecondTask extends FirstTask {
    String[] words;

    public SecondTask(String[] words){
        super(words);
        this.words = words;
    }

    public void getSortedArrayWordsToLength()
    {
        List<String> words = new ArrayList<String>();
        Collections.addAll(words, this.words);

        Comparator<String> wordsSorter = (word1, word2) -> word1.length() - word2.length();
        words.stream().sorted(wordsSorter).forEach(System.out::println);

    }
}
