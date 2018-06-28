package ru.sbt.collections;

import java.util.*;

public class CollectionUtils {
    public static void main( String[] args ) {
        List list2 = range( Arrays.asList( 8, 1, 3, 5, 6, 4 ), 3, 6 );
        for ( int i = 0; i < list2.size(); i++ ) {
            System.out.println( list2.get( i ) );
        }
    }

    // пример параметризации метода и его реализации:
    public static <T> void addAll( List<? extends T> source, List<? super T> destination ) {
        destination.addAll( source );
    }

    //Создать новый List из c вернуть в виде List
    public static <T> List newArrayList( List<? extends T> c ) {
        return new ArrayList<>( c );
    }

    //индекс элемента в листе
    public static <T> int indexOf( List<? extends T> source, T o ) {
        return source.indexOf( o );
    }

    //вернуть лист длиной не более size
    public static <T> List limit( List<? extends T> source, int size ) {
        return new ArrayList<>( source ).subList( 0, size );
    }

    //добавить элемент в конец листа
    public static <T> void add( List<? super T> source, T o ) {
        source.add( o );
    }

    //удалить все вхождения элемента c2
    public static <T> void removeAll( List<? super T> removeFrom, List<? extends T> c2 ) {
        removeFrom.removeAll( c2 );
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll( List<? extends T> c1, List<? extends T> c2 ) {
        return c1.containsAll( c2 );
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny( List<? extends T> c1, List<? extends T> c2 ) {
        for ( T t : c2 ) {
            if ( c1.contains( t ) )
                return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>> List range( List<? extends T> list, T min, T max ) {
        List<? super T> retList = new ArrayList<>();
        Collections.sort( list );
        for ( T ls : list ) {
            if ( ls.compareTo( min ) >= 0 && ls.compareTo( max ) <= 0 ) {
                retList.add( ls );
            }
        }
        return retList;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
// Элементы сравнивать через comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>>  List range( List<? extends T> list, T min, T max, Comparator comparator ) {
        List<? super T> retList = new ArrayList<>();
        Collections.sort( list, comparator );
        for ( T ls : list ) {
            if ( ls.compareTo( min ) >= 0 && ls.compareTo( max ) <= 0 ) {
                retList.add( ls );
            }
        }
        return retList;
    }
}