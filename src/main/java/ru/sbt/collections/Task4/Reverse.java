package ru.sbt.collections.Task4;

import org.apache.commons.io.IOUtils;
import ru.sbt.collections.Task1.DifferentWords;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Stack;

/**
 * Задание 4: Выведите на экран все строки файла в обратном порядке.
 */
public class Reverse {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Reverse.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String text = IOUtils.toString(resourceAsStream, "UTF8");

        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(text.split("\r\n")));
        while (!stack.empty())
            System.out.println(stack.pop());

        System.out.println("Всего различных слов: " + text.length());
    }
}
