package ru.sbt.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;

public class CheckGenerics {
    public static void main(String[] args) {
        CountMap<String> testMap = new CountMapImpl<>();

//        testMap.add("four"); testMap.add("three"); testMap.add("two");
//        testMap.add("four"); testMap.add("three");
//        testMap.add("four"); testMap.add("three"); testMap.add("two"); testMap.add("one");
//        testMap.add("four");

        testMap.add("four");
        testMap.add("three");
        testMap.add("two");
        testMap.add("four");
        testMap.add("three");
        testMap.add("four");
        testMap.add("three");
        testMap.add("two");
        testMap.add("one");
        testMap.add("four");

        System.out.println("one: " + testMap.getCount("one"));
        System.out.println("two: " + testMap.getCount("two"));
        System.out.println("three: " + testMap.getCount("three"));
        System.out.println("four: " + testMap.getCount("four"));
        System.out.println("Size: " + testMap.size());

        testMap.toMap().forEach((k, v) -> System.out.println(k + " => " + v));
        System.out.println("\n\n*******************************************\n\n");

        ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(1, 7, 3, 8));
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 7, 5, 2));

        CollectionUtils.addAll(integers, numbers);
        System.out.println("Expect 1,7,3,8,1,7,5,2: " + numbers);

        //Создать новый List из c вернуть в виде List
        List<Number> check = CollectionUtils.newArrayList(integers);
        System.out.println("Expect 1,7,5,2: " + check);

        //индекс элемента в листе
        int index = CollectionUtils.indexOf(numbers, 8);
        System.out.println("Expect 3: " + index);

        //вернуть лист длиной не более size
        check = CollectionUtils.limit(integers, 3);
        System.out.println("Expect 1,7,5: " + check);

        //добавить элемент в конец листа
        numbers = new ArrayList<>(Arrays.asList(1, 7, 3, 8));
        integers = new ArrayList<>(Arrays.asList(1, 7, 5, 2));
        CollectionUtils.add(numbers, new Integer(5));
        System.out.println("Expect 1,7,3,8,5: " + numbers);

        //удалить все вхождения элемента c2
        CollectionUtils.removeAll(numbers, integers);
        System.out.println("Expect 3,8: " + numbers);

        //true если первый лист содержит все элементы второго
        boolean every = CollectionUtils.containsAll(numbers, integers);
        System.out.println("Expect false: " + every);

        numbers = new ArrayList<>(Arrays.asList(1, 7));
        integers = new ArrayList<>(Arrays.asList(1, 7));
        every = CollectionUtils.containsAll(numbers, integers);
        System.out.println("Expect true: " + every);

        //true если первый лист содержит хотя-бы 1 второго
        numbers = new ArrayList<>(Arrays.asList(1, 5, 2));
        integers = new ArrayList<>(Arrays.asList(7, 3, 9));
        boolean any = CollectionUtils.containsAny(numbers, integers);
        System.out.println("Expect false: " + any);

        numbers = new ArrayList<>(Arrays.asList(1, 5, 2));
        integers = new ArrayList<>(Arrays.asList(7, 1, 9));
        any = CollectionUtils.containsAny(numbers, integers);
        System.out.println("Expect true: " + any);


        //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
        // Элементы сравнивать через Comparable.
        // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
        integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Number> ranged = CollectionUtils.range(integers, 2, 5);
        System.out.println("Expect 3,4: " + ranged);


        //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
        // Элементы сравнивать через comparator.
        // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
        integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ranged = CollectionUtils.range(integers, 2, 5, (first, second) -> first - second);
        System.out.println("Expect 3,4: " + ranged);
    }
}
