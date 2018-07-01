package ru.sbt.collections;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class CheckTasks {
    public static void main(String[] args) throws IOException, URISyntaxException {
        InputStream resourceAsStream = CheckTasks.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String text = IOUtils.toString(resourceAsStream, "UTF8");
        CollectionsTasks tasks = new CollectionsTasks(text);

        int different = tasks.DifferentWords();
        System.out.println("Different words: " + different);

        different = tasks.SortedWords();
        System.out.println("Different words: " + different);

        tasks.CountUses();
        tasks.reverseLines();
        tasks.checkIterator();
        tasks.showSpecifiedLines();
        System.out.println("Finished");
    }
}
