package ru.sbt.collections;


import java.util.*;

public class CollectionUtils {
    //T data;

    // пример параметризации метода и его реализации:
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    //Создать новый List из c вернуть в виде List
    public static <T> List newArrayList(List <? extends T> source) {
        List<T> list = new ArrayList<>(source);
        return (List<T>) list;
    }
    //индекс элемента в листе
    public static <T> int indexOf(List <? extends T> source, Object o) {
        return  source.indexOf(o);
    }
    //вернуть лист длиной не более size
    public static <T> List limit(List <? extends T> source, int size) {
        return source.subList(0, size);
    }
    //добавить элемент в конец листа
    public static <T> void add(List <? super T> source, T o) {
        source.add(o);
    }
    //удалить все вхождения элемента c2
    public static <T> void removeAll(List <? super T> removeFrom, List <? extends T> c2) {
        removeFrom.removeAll(c2);
    }
    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List <? super T> c1, List <? extends T> c2) {
        return  c1.containsAll(c2);
    }
    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List <? super T> c1, List <? extends T> c2) {
        boolean value = false;
        for ( T t : c2 ) {
            if (c1.contains( t )) {
                value = true;
                break;
            }
        }
        return value;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}



    public static <T extends  Comparable<? super T>>  List <T> range(List <T> list, T min, T max)  {

        for (int i=0; i<list.size()-1; i++)
        {
            if (list.get( i ).compareTo(max)>0||list.get( i ).compareTo(min)<0) {
                list.remove( i );
            }
        }
        return list;
    }


    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparator <? super T>> List <T> range(List <T> list, T min, T max, Comparator <T> comparator) {
        int i=0;
        if ( comparator.compare(list.get( i ), max )>0||comparator.compare(list.get( i ), min)<0)
        list.remove( i );
        return list;

    }
}
