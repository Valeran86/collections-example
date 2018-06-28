package ru.sbt.collections;

public class TestCountMap {
    public static void main( String[] args ) {
        //пример использования
        CountMap<Integer> map = new CountMap<>();
        map.add( 10 );
        map.add( 10 );
        map.add( 5 );
        map.add( 6 );
        map.add( 5 );
        map.add( 10 );
        System.out.println( map.getCount( 5 ) + " | " + map.getCount( 6 ) + " | " + map.getCount( 10 ) + " | ");
    }
}
