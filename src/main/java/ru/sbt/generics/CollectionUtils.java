package ru.sbt.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    // пример параметризации метода и его реализации:
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    //Создать новый List из c вернуть в виде List
    public static <T> List<? super T> newArrayList(List<? extends T> c) {
        List<? super T> res = new ArrayList<>(c);
        return res;
    }
    //индекс элемента в листе
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }
    //вернуть лист длиной не более size
    public static <T> List<? super T> limit(List<? extends T> source, int size) {
        return newArrayList(source.subList(0, size));
    }
    //добавить элемент в конец листа
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }
    //удалить все вхождения элемента c2
    public static <T> void removeAll(List<? extends T> removeFrom, T c2) {
        removeFrom.remove(c2);//посмотреть документацию, чтобы этот метод удалял все вхождения
    }
    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }
    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T e: c2) {
            if (c1.contains(e))
                return true;
        }
        return false;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<T>> List range(List<? extends T> list, T min, T max) {
        List<? super T> res = new ArrayList<>();
        for (T e: list) {
            if (e.compareTo(min) >= 0 && e.compareTo(max) <= 0)
                res.add(e);
        }
        return res;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<? super T> res = new ArrayList<>();
        for (T e: list) {
            if (comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0)
                res.add(e);
        }
        return res;
    }
}

