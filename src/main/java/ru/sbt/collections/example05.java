package ru.sbt.collections;

// Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.

import java.util.ArrayList;
import java.util.Iterator;

public class example05 {

    public static void main(String[] args) {

        // Странно, если тут пишу "/ru/sbt/collections/VeryBigText.txt" файл не находит
        String fileName = "l:/Kurs/sbertech2018/forks/collections-example/target/classes/ru/sbt/collections/VeryBigText.txt";

        // Считываем файл построчно в список
        ArrayList<String> strings = Counter1DifferentWords.getStringArray(fileName);

        // Сожмем список до реального размера
        strings.trimToSize();

        Iterator<String> iterator = new ReverseIterator(strings);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
