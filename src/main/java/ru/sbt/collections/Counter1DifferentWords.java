package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;


/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );
        // System.out.println( lines );
        // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println("Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.");

        String reg = "[\\s ,; \\. ()—System.lineSeparator()]";
        String[] words = lines.split(reg);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) {
             Integer frequency = map.get(words[i]);
            if ((words!=null)&&(!words[i].equals("")))
            map.put(words[i], frequency == null ? 1 : frequency + 1);
        }


        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue()==null) {
                System.out.println("Слово " + pair.getKey() + "встречается 0 раз");
            }
            else {
                System.out.println("Слово " + pair.getKey()+ " встречается " + pair.getValue() + " раз");
            }
        }

        // Задание 4: Выведите на экран все строки файла в обратном порядке.
        System.out.println("Задание 4: Выведите на экран все строки файла в обратном порядке.");
        ArrayList<String> lWords = new ArrayList<String>();
        for (int i=0; i<words.length; i++)  {
            if ((words!=null)&&(!words[i].equals("")))
                lWords.add(words[i]);
        }
        for (int i=lWords.size()-1; i>-1; i--)  {
        System.out.println(lWords.get(i));
        }

        // Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.

        System.out.println("Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.");
        ArrayList<String> reversList= new ArrayList<String>();
        for (int i=0; i<words.length; i++) {
            if ((words!=null)&&(!words[i].equals("")))
                reversList.add(words[i]);
        }

        RIteraror iter = new RIteraror(reversList);
       while (iter.hasPrevious()) {
        System.out.println(iter.previous());
        }


        //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        System.out.println("Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        BufferedReader  reader= new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split("\\s");
        ArrayList<Integer> userNum= new ArrayList<Integer>();
        for (int i=0; i<strings.length;i++) {
            userNum.add((Integer.parseInt(strings[i])));
        }
        System.out.println(userNum.size());

        for (int i=0; i<userNum.size(); i++) {
            System.out.println(lWords.get(i));

        }

        for (int i=0; i<userNum.size(); i++) {
            System.out.println(lWords.get(userNum.get(i)));
        }
    }
}






