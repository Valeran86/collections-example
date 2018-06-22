package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class Counter3DifferentWords {

    public static void main(String[] args) throws IOException, URISyntaxException {
        int min = 1000, max = 0;
        int count_of_unique_word;
        InputStream resourceAsStream = Counter3DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString(resourceAsStream, "UTF8");

        Pattern pattern = Pattern.compile("[\n\t,.!?;: ]");
        ArrayList<String> al = new ArrayList<>();
        TreeSet<String> ts = new TreeSet<>();

        for (String temp : pattern.split(lines)) {
            al.add(temp);
            ts.add(temp);
        }

        for (String temp : ts) {
            if(temp.length() > max){
                max = temp.length();
            }
            if(temp.length() < min){
                min = temp.length();
            }
        }

        System.out.println();

        for(int i = min; i <= max; i++){
            for(String temp1 : ts){
                count_of_unique_word = 0;
                if(temp1.length() == i){
                    for(String temp2 : al){
                        if(temp1.equals(temp2)){
                            count_of_unique_word++;
                        }
                    }
                    System.out.println("" + temp1 + " (" + i + ")/" + count_of_unique_word + " раз");
                }
            }
        }

    }
}


