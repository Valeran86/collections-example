package ru.sbt.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// used :   https://habr.com/post/207360/
public class CollectionUtils   {
    // пример параметризации метода и его реализации:

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    //Создать новый List из c вернуть в виде List
    public static <T> List<? super T>  newArrayList(List<? extends T>  с) {
        List<? super T> result =new ArrayList<>();
        result.addAll(с);
        return result;
    }
    //индекс элемента в листе
    public static <T>  int   indexOf( List <? super T> source, T o) {
        return source.indexOf( o );
    }
    //вернуть лист длиной не более size
    public static  <T>   List <? super T>  limit(List <? extends T> source, int size) {
        List <? super T> result =new ArrayList<>(  ) ;
        if (size <0)
            return result;
        int max = size <=source.size() ? size : source.size();
        for ( int i = 0; i <max ; i++ ) {
            result.add( source.get( i ) );
        }
        return result ;
    }
    //добавить элемент в конец листа
    public static  <T>  void add(List  <? super T>  source, T o) {
        source.add( o );
    }
    //удалить все вхождения элемента c2
    public static  <T>  void removeAll(List  <? super T >  removeFrom, List  <? extends T> c2) {
        removeFrom.removeAll( c2 );
    }
    //true если первый лист содержит все элементы второго
    public static <T>   boolean containsAll(List  <? extends T> c1, List  <? extends T> c2) {
        return c1.containsAll( c2 );
    }
    //true если первый лист содержит хотя-бы 1 второго
    public static <T>   boolean containsAny(List  <? extends T> c1, List  <? extends T>  c2) {
        for ( T o : c2) {
            if (c1.contains( o )){
                return true;
            }
        }
        return false;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public   static  <T extends Comparable>    List  <? super T>  range(List <? extends T>  list, T  min, T max) {
        List  <? super T> result = new ArrayList<>(  );
        for (T o :    list     ) {
            if(o.compareTo(min)>=0 && o.compareTo(max)<=0){
                result.add(o);
            }
        }
        return result;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static  <T>  List <? super T>  range(List  <? extends T> list, T min, T max, Comparator  <  T> comparator) {
        List <? super T> result = new ArrayList<>(  );
        for (T o :    list     ) {
            if(comparator.compare(o,min)>=0 && comparator.compare(o,max)<=0){
                result.add(o);
            }
        }
        return result;
    }
}

