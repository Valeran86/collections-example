package ru.sbt.collections;

import java.util.HashMap;
import java.util.Map;

public class TestContaner {
    public static void main(String[] args) {

        CountMap<String> countMap = new MyCountMap<String>();
        CountMap<String> newCountMap = new MyCountMap<String>();

        System.out.println("Добавим элементы:");
        // Добавим элементы в countMap
        countMap.add("a");
        countMap.add("b");
        countMap.add("c");
        countMap.add("d");
        countMap.add("d");
        countMap.add("d");
        countMap.add("e");
        countMap.add("e");
        countMap.add("e");
        countMap.add("e");
        countMap.add("f");
        countMap.add("f");
        countMap.add("f");
        countMap.add("f");

        System.out.println(countMap.toString());

        //Удалим d
        System.out.println("Удалим d");
        System.out.println(countMap.remove("d"));
        System.out.println(countMap.toString());

        // Добавим все элементы countMap в newCountMap
        System.out.println("Добавим все элементы countMap в newCountMap");
        newCountMap.addAll(countMap);
        System.out.println(newCountMap.toString());

        Map<String, Integer> mymap = new HashMap<String, Integer>();
        System.out.println("toMap destination");
        countMap.toMap(mymap);
        System.out.println(mymap.toString());


    }
}
