package ru.sbt.collections;

import java.util.*;

class CollectionUtils {
    // пример параметризации метода и его реализации:
    static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    //Создать новый List из c вернуть в виде List
    static <T> List<? super T> newArrayList(List<? extends T> с) {
        return new ArrayList<>(с);
    }

    //индекс элемента в листе
    static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }
    //вернуть лист длиной не более size
    static <T> List<? super T> limit(List<? extends T> source, int size) {
        int toIndex=subListRangeCheck(size, source.size());
        return newArrayList(source.subList(0,toIndex));
    }

    private static int subListRangeCheck(int toIndex, int size) {
        if (toIndex > size) {
            return size;
        }
        if(toIndex<0){
            throw new IllegalArgumentException(toIndex+"<0");
        }
        return toIndex;
    }

    //добавить элемент в конец листа
    static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }
    //удалить все вхождения элемента c2
    static <T> void removeAll(List<? extends T> removeFrom, T c2) {
        List<T> t=new ArrayList<>();
        t.add(c2);
        removeFrom.removeAll(t);
    }

    //true если первый лист содержит все элементы второго
    static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }
    //true если первый лист содержит хотя-бы 1 второго
    static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for(T t:c2){
            if(c1.contains(t)){
                return true;
            }
        }
        return false;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}

    static <T extends Comparable<T>> List<? super T>  range(List<? extends T> list, T min, T max) {
        Collections.sort(list);
        List<? super T> listShort=new ArrayList<>();
        for (T aList : list) {
            if (aList.compareTo(min) >= 0 && aList.compareTo(max) <= 0) {
                listShort.add(aList);
            }
        }
        return listShort;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        list.sort(comparator);
        List<? super T> listShort=new ArrayList<>();
        for (T aList : list) {
            if (comparator.compare(aList, min) >= 0 && comparator.compare(aList, max) <= 0) {
                listShort.add(aList);
            }
        }
        return listShort;
    }


}
