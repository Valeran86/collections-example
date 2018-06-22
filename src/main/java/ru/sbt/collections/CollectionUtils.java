package ru.sbt.collections;

import java.util.*;

public class CollectionUtils {
    // пример параметризации метода и его реализации:
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    //Создать новый List из c вернуть в виде List
    public static <T> List<? super T> newArrayList(List<? extends T> с) {
        List<? super T> newList=new ArrayList<>();
        newList.addAll(с);
        return newList;
    }

    //индекс элемента в листе
    public static <T> int indexOf(List<? extends T> source, T o) {
        if (o != null) {
            for (int i = 0; i < source.size(); i++)
                if (o.equals(source.get(i)))
                    return i;
        }
        return -1;
    }
    //вернуть лист длиной не более size
    public static <T> List<? super T> limit(List<? extends T> source, int size) {
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
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }
    //удалить все вхождения элемента c2
    public static <T> void removeAll(List<? super T> removeFrom, T c2) {
//Выбрал такой способ потому как, насколько помню по статье и как понял ArrayList.batchRemove,
//При removeAll - будет смещение единожды массива. А при вызове в цикле remove(Object) - каждый раз при удалении.
        List<? super T> a= new ArrayList<>();
        a.add(c2);
        removeFrom.removeAll(a);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        for(int i=0;i<c2.size();i++){
            if(c1.indexOf(c2.get(i))<0) return false;
        }
        return true;
    }
    //true если первый лист содержит хотя-бы 1 второго
    public static boolean containsAny(List c1, List c2) {
        for(int i=0;i<c2.size();i++){
            if(c1.indexOf(c2.get(i))>-1) return true;
        }
        return false;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}

    public static <T extends Comparable<T>> List<? super T>  range(List<? extends T> list, T min, T max) {
        Collections.sort(list);
        List<? super T> listShort=new ArrayList<>();
        for(int i=0; i<list.size();i++){
            int r=list.get(i).compareTo(min);
            if(list.get(i).compareTo(min)>=0 && list.get(i).compareTo(max)<=0){
                listShort.add(list.get(i));
            }
        }

        return listShort;
    }




    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        Collections.sort(list, comparator);
        List<? super T> listShort=new ArrayList<>();
        for(int i=0; i<list.size();i++){
            if(comparator.compare(list.get(i),min)>=0 && comparator.compare(list.get(i),max)<=0){
                listShort.add(list.get(i));
            }
        }
        return listShort;
    }


}
