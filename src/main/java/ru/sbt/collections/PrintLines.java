package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

//Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
public class PrintLines {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Введите номер строки для вывода. CTRL + C, чтобы выйти");
        String[] lines = Reader.readLines();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n >= lines.length)
                System.out.println("Введенное число больше длины массива");
            else
                System.out.println(lines[n]);
        }
    }
}
