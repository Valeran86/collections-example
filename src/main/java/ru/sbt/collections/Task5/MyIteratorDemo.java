package ru.sbt.collections.Task5;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
 */
public class MyIteratorDemo {
    public static void main(String[] args) {
        String[] strings = {"0", "1", "2", "3", "4", "5", "6"};
        List<String> list = Arrays.asList(strings);
        MyIterator iter = (MyIterator) list.listIterator();
    }
}
