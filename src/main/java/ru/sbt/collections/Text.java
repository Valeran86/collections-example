package ru.sbt.collections;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
/**
 * Создаем класс со статическим методом для получения текста чтобы не повторяться
 */
public class Text {

    public static String getText()throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );
        return lines;
    }

    public static String[] getWordsInArray()throws IOException, URISyntaxException {
        String words = Text.getText();
        words = words.replaceAll("[!?,—)(;:.\\-\\[\\]1234567890$]", " ");
        String[] arrayWords = words.split("\\s+");
        return arrayWords;
    }

    public static String[] getStringsInArray()throws IOException, URISyntaxException {
        String words = Text.getText();
        String[] arrayStrings = words.split("\\.+");
        return arrayStrings;
    }
}
