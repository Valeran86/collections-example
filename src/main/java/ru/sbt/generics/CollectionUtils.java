package ru.sbt.generics;
import java.util.*;

public class CollectionUtils {

    //SonarList посоветовал создать такой конструктор
    private CollectionUtils() {
        throw new IllegalStateException("Utility class");
    }

    // пример параметризации метода и его реализации:
    public static <T> void addAll( List<? extends T> source, List <? super T> destination ) {
        destination.addAll( source );
    }

    //Создать новый List из c вернуть в виде List
    public static  <T> List newArrayList( List <? extends T> c ) {
        List<? super T> newUserArray = new ArrayList <>();
        newUserArray.addAll( c );
        return newUserArray;
    }

    //индекс элемента в листе
    public static <T> int indexOf( List <? extends T> source, T o ) {
       return source.indexOf( o );
    }

    //вернуть лист длиной не более size
    public static <T> List limit( List <? extends T> source, int size ) {
        List<? super T> newUserArray = new ArrayList( source.subList( 0,size ) );
        return newUserArray;
    }

    //добавить элемент в конец листа (метод передает данные в аргумент)
    public static <T> void add( List <? super T> source, T o ) {
        source.add( o );
    }

    //удалить все вхождения элемента c2 (метод передает данные в аргумент)
    public static <T> void removeAll( List <? super T> removeFrom, T c2 ) {
        removeFrom.removeAll( Collections.singleton(c2) );
    }

    //true если первый лист содержит все элементы второго
    //(читаем из второго аргумента, передаем в первый)
    public static <T> Boolean containsAll( List <? super T> c1, List <? extends T> c2 ) {
        return c1.containsAll( c2 );
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> Boolean containsAny( List <? super T> c1, List <? extends T> c2 ) {
       return !Collections.disjoint( c1, c2 );
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    public static <T extends Comparable<T>> List range( List <? extends T> list, T min, T max ) {
        List<? super T> rangeOnArray = new ArrayList<>();

        Collections.sort(list);
        for(T element : list){
            if(element.compareTo( min ) >= 0 && element.compareTo( max ) <= 0){
                rangeOnArray.add(element);
            }
        }
        return rangeOnArray;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через comparator.
    public static <T> List range( List <? extends T> list, T min, T max, Comparator <T> comparator ) {
        List<? super T> rangeOnArray = new ArrayList<>();
        Collections.sort(list, comparator);
        for(T element : list){
            if(comparator.compare(element, min ) >= 0 && comparator.compare(element, max ) <= 0){
                rangeOnArray.add(element);
            }
        }
        return rangeOnArray;
    }

}
