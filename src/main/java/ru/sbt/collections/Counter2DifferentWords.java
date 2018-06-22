package ru.sbt.collections;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Выведите на экран список различных слов файла, отсортированный по возрастанию их длины. 
 */
public class Counter2DifferentWords {
    public static void main(String[] args) throws IOException, URISyntaxException {
        int i = 0, min = 1000, max = 0;
        InputStream resourceAsStream = Counter3DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString(resourceAsStream, "UTF8");

        Pattern pattern = Pattern.compile("[\n\t,.!?;: ]");
        HashSet<String> hs = new HashSet<>();

        for (String temp : pattern.split(lines)) {
            hs.add(temp);
            if(temp.length() > max){
                max = temp.length();
            }
            if(temp.length() < min){
                min = temp.length();
            }
        }

        System.out.println();
        for(int j = min; j <= max; j++){
            for(String word : hs) {
                if(word.length() == j){
                    i++;
                    System.out.println("" + i + " " + word + " (" + j + ")");
                }
            }
        }
    }
}
