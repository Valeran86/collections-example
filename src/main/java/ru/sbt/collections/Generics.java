package ru.sbt.collections;

public class Generics {
    public static void main( String[] args ) {
        CountMap <String> countMap = new CountMapImpl<>();
        countMap.add( "Вася" );
        countMap.add( "Петя" );
        countMap.add( "Маша" );
        countMap.add( "Егор" );
        countMap.add( "Таня" );
        countMap.add( "Надя" );
        countMap.add( "Вася" ); // снова Вася +2

        System.out.println("Размер [6]: " + countMap.size());

        System.out.println("Маша [1]: " + countMap.getCount("Маша"));
        System.out.println("Вася [2]: " + countMap.getCount("Вася"));
        System.out.println("Портфель [0]: " + countMap.getCount("Портфель"));

        System.out.println("remove Вася [2]:" + countMap.remove( "Вася" ) );
        System.out.println("getCount Вася [0]:" + countMap.getCount( "Вася" ) );

        // добавим только женские имена и сольем  их вместе:
        CountMap <String > countMap2 = new CountMapImpl<>();
        countMap2.add( "Маша" );
        countMap2.add( "Таня" );
        countMap2.add( "Надя" );

        System.out.println();
        System.out.println("Сольем две мапы");
        countMap2.addAll (countMap);
        System.out.println("Маша [1+1]: " + countMap2.getCount("Маша"));
        System.out.println("Таня [1+1]: " + countMap2.getCount("Таня"));
        System.out.println("Егор [1+0]: " + countMap2.getCount("Егор"));



    }

}
