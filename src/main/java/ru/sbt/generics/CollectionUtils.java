package ru.sbt.generics;


import java.util.*;

public class CollectionUtils {
    /**
     * Пример параметризации метода и его реализации:
     *
     * @param source
     * @param destination
     * @param <T>
     */
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    /**
     * Создает новый List из c вернуть в виде List
     *
     * @param с
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList(List<? extends T> с) {
        return new ArrayList<>(с);
    }

    /**
     * @param source
     * @param o
     * @return индекс элемента в листе
     */
    public static <T> int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    /**
     * @param source
     * @param size
     * @return лист длиной не более size
     */
    public static <T> List<T> limit(List<? extends T> source, int size) {
        return source.size() >= size ?
                new ArrayList<>(source.subList(0, size)) :
                new ArrayList<>(source);
    }

    /**
     * Добавляет элемент в конец листа
     *
     * @param source
     * @param o
     */
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    /**
     * Удаляет все вхождения элемента c2
     *
     * @param removeFrom
     * @param c
     */
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c) {
        removeFrom.removeAll(c);
    }

    /**
     * @param c1
     * @param c2
     * @return true если первый лист содержит все элементы второго
     */
    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    /**
     * @param c1
     * @param c2
     * @return true если первый лист содержит хотя-бы 1 второго
     */
    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T item : c2) {
            if (c1.contains(item))
                return true;
        }
        return false;
    }

    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}

    /**
     * @param c
     * @param min
     * @param max
     * @return лист, содержащий элементы из входного листа в диапазоне от min до max (Включительно?)
     */
    public static <T extends Comparable<T>> List range(List<? extends T> c, T min, T max) {
        List<T> result = new ArrayList<>();
        for (T item : c) {
            if (item.compareTo(min) > 0 && item.compareTo(max) < 0)
                result.add(item);
        }

        return result;
    }

    // Элементы сравнивать через comparator.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}

    /**
     * @param c
     * @param min
     * @param max
     * @param comparator
     * @return лист, содержащий элементы из входного листа в диапазоне от min до max.
     */
    public static <T> List range(List<? extends T> c, T min, T max, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        for (T item : c) {
            if (comparator.compare(item, min) > 0 && comparator.compare(item, max) < 0)
                result.add(item);
        }
        return result;
    }
}

