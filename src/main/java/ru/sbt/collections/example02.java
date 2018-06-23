package ru.sbt.collections;

//Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class example02 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String fileName = "/ru/sbt/collections/VeryBigText.txt";

        String lines = Counter1DifferentWords.getString(fileName);

        String [] words = lines.split("\\p{P}?[ \\t\\n\\r]+");
        HashSet<String> hashSet = new HashSet(Arrays.asList(words));

        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();

        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext()){
            String stroka = iterator.next();
            if (!treeMap.containsKey(stroka.length())) treeMap.put(stroka.length(), new ArrayList<String>());
            treeMap.get(stroka.length()).add(stroka);
        }

        System.out.println(treeMap.toString());


    }
}
