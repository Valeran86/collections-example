package ru.sbt.collections.first;

import java.util.*;
import java.util.stream.Collectors;

public class FirstTask {

    String[] words;
    Map<String, Long> uniqueWords;

    public FirstTask (String[] words){

        this.words = words;
        this.uniqueWords = getUniqueWords();
    }

    public Map<String, Long> getUniqueWords()
    {
        Map<String, Long> mapArray = Arrays.stream(this.words)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return mapArray;
    }

    public void printCountUniqueSizeWords()
    {
        System.out.println("Количество различных слов в файле: " + this.uniqueWords.size());
    }

    public void printWordsFromArray()
    {
        for(int i = 0; i < this.words.length; i++)
        {
            System.out.println("Cлово " + i + " " + this.words[i]);
        }
    }

    public void printCountWordsFromArray()
    {
        System.out.println("Всего слов в массиве: " + this.words.length);
    }
}
