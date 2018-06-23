package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
//Задание 4: Выведите на экран все строки файла в обратном порядке.
public class ReverseInputStrings {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String[] lines = Reader.readLines();
        for (int i = lines.length-1; i>=0; i--) {
            System.out.println(lines[i]);
        }
    }
}
