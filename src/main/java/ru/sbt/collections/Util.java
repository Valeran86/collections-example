package ru.sbt.collections;


public class Util {
    public static String[] lines2words(String lines) {
        return lines.split("[^a-zA-Zа-яА-Я,.]+", -1);
    }
}
