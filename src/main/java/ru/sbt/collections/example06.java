package ru.sbt.collections;

// Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.

import java.util.ArrayList;
import java.util.Scanner;

public class example06 {

    public static void main(String[] args) {
        // Странно, если тут пишу "/ru/sbt/collections/VeryBigText.txt" файл не находит
        String fileName = "l:/Kurs/sbertech2018/forks/collections-example/target/classes/ru/sbt/collections/VeryBigText.txt";
        // Считываем файл построчно в список
        ArrayList<String> strings = Counter1DifferentWords.getStringArray(fileName);
        // Сожмем список до реального размера
        strings.trimToSize();
        System.out.print("Ввежите номер строки... ");
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println(strings.get(scanner.nextInt()));
        } catch (IndexOutOfBoundsException e){
            System.out.println("Нет такой строки!");
            //e.printStackTrace();
        }
    }

}
