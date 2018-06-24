package ru.sbt.collections.third;

import ru.sbt.collections.first.FirstTask;

import java.util.*;

public class ThirdTask extends FirstTask {

    public ThirdTask(String[] words){
        super(words);

    }

    public void showUniqueWords(){
        Map<String, Long> uniqueWords = this.getUniqueWords();

        System.out.println("Список уникальных слов и их количество: ");
        Iterator it = uniqueWords.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry word = (Map.Entry)it.next();
            System.out.println("\""+word.getKey()+"\" " + word.getValue());
            it.remove();
        }
    }
}
