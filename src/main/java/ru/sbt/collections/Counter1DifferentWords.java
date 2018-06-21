package ru.sbt.collections;


import com.sun.xml.internal.ws.util.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 */
public class Counter1DifferentWords {
    private static PrintWriter outResult;


    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );

        outResult = new PrintWriter("result2.txt");

        System.out.println("Исходный текст: ");
        outResult.println("Исходный текст: ");
        System.out.println( lines );
        outResult.println(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 1: Подсчитайте количество различных слов в файле.");
        Set<String> uniqueWords=TaskOne(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.");
        TaskTwo(uniqueWords);
        System.out.println();
        outResult.println();
        outResult.println("Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.");
        TaskTreeImplTwo(getWords(lines));
        System.out.println();
        outResult.println();
        outResult.println("Задание 4: Выведите на экран все строки файла в обратном порядке. Реализация 1.");
        TaskFourImplOne(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 4: Выведите на экран все строки файла в обратном порядке. Реализация 2.");
        TaskFourImplTwo(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.");
        TaskFive(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        TaskSix(lines);

        outResult.close();
    }

}
