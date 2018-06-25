package ru.sbt.collections;

// Задание 4: Выведите на экран все строки файла в обратном порядке.

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class example04 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        // Странно, если тут пишу "/ru/sbt/collections/VeryBigText.txt" файл не находит
        String fileName = "l:/Kurs/sbertech2018/forks/collections-example/target/classes/ru/sbt/collections/VeryBigText.txt";

        // Считываем файл построчно в список
        ArrayList<String> strings = Counter1DifferentWords.getStringArray(fileName);

        // Сожмем список до реального размера
        strings.trimToSize();

        // Инвертируем его
        Collections.reverse(strings);

        // Выведем на экран
        for (String s : strings){
            System.out.println(s);
        }
    }
}