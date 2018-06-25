package ru.sbt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    // пример параметризации метода и его реализации:
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    //Создать новый List из c вернуть в виде List
    public static <T> List<? super T> newArrayList(List<? extends T> c) {
        return new ArrayList<>(c);
    }

    //индекс элемента в листе
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    //вернуть лист длиной не более size
    public static <T> List limit(List<? extends T> source, int size) {
        List<T> newlist = new ArrayList<T>(size);
        newlist.addAll( source );
        return newlist;
    }

    //добавить элемент в конец листа
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    //удалить все вхождения элемента c2
    public static <T> void removeAll(List<? extends T> removeFrom, T c2) {
        for (T el : removeFrom) {
            if (el.equals(c2)) removeFrom.remove(c2);
        }
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T el : c2) {
            if (c1.contains(el)) return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<T>> List range(List<? extends T> list, T min, T max) {
        List<T> newlist = new ArrayList<>();

        Collections.sort(list);
        for(T el : list){
            if( ( el.compareTo( min ) >= 0 ) && ( el.compareTo( max ) ) <= 0){
                newlist.add(el);
            }
        }

        return newlist;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через comparator.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List range( List <? extends T> list, T min, T max, Comparator <T> comparator ) {
        List<T> newlist = new ArrayList<>();

        Collections.sort(list, comparator);
        for(T el : list){
            if(comparator.compare(el, min ) >= 0 && comparator.compare(el, max ) <= 0){
                newlist.add(el);
            }
        }

        return newlist;
    }


}
