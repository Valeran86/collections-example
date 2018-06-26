package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

import static ru.sbt.collections.Util.lines2words;
import static ru.sbt.collections.Util.words2set;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream( "/ru/sbt/collections/VeryBigText.txt" );
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );

        lesson1( lines );
        lesson2( lines );
        lesson3( lines );
        lesson4( lines );
        lesson5( lines );
        lesson6( lines );
    }

    // Задание 1: Подсчитайте количество различных слов в файле.
    public static void lesson1( String lines ) {
        List<String> items = Arrays.asList( lines2words( lines ) );
        Set<String> set = words2set( items );
        System.out.println( "================================ Задание 1: Подсчитайте количество различных слов в файле." );
        System.out.println( "Уникальных слов = " + set.size() );

    }

    // Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
    public static void lesson2( String lines ) {
        List<String> items = Arrays.asList( lines2words( lines ) );
        Set<String> set = words2set( items );
        List<String> mainList = new ArrayList<>( set );

        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare( String o1, String o2 ) {
                return Integer.compare( o1.length(), o2.length() );
            }
        };
        Collections.sort( mainList, stringLengthComparator );
        System.out.println( "================================ Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины." );
        for ( String item : mainList ) {
            System.out.println( item );
        }
    }

    // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public static void lesson3( String lines ) {
        List<String> items = Arrays.asList( lines2words( lines ) );
        Map<String, Integer> map = new HashMap<>();
        for ( String item : items ) {
            map.merge( item, 1, Integer::sum );
        }
        System.out.println( "================================ Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле." );
        for ( Map.Entry<String, Integer> entry : map.entrySet() ) {
            System.out.println( "Слово: '" + entry.getKey() + "', встречается: " + entry.getValue() );
        }
    }

    // Задание 4: Выведите на экран все строки файла в обратном порядке.
    public static void lesson4( String lines ) {
        System.out.println( "================================ Задание 4: Выведите на экран все строки файла в обратном порядке." );
        List<String> items = new ArrayList<>( Arrays.asList( lines.split( "[\n]" ) ) );
        for ( int i = items.size() - 1; i >= 0; i-- ) {
            System.out.println( items.get( i ) );
        }
    }

    // Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
    public static void lesson5( String lines ) {
        System.out.println( "================================ Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке." );
        List<String> items = new ArrayList<>( Arrays.asList( lines.split( "[\n]" ) ) );
        ReverseList reverseList = new ReverseList( items );

        while ( reverseList.iterator().hasNext() ) {
            System.out.println( reverseList.iterator().next() );
        }
    }

    // Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    public static void lesson6( String lines ) {
        System.out.println( "================================ Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке." );
        List<String> items = new ArrayList<>( Arrays.asList( lines.split( "[\\r\\n]+" ) ) );
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Введите, через запятую, номера строк: " );
        String enterLine = scanner.nextLine();
        String[] nums = enterLine.split( "[^0-9]+" );
        for ( int i = 0; i < nums.length; i++ ) {
            System.out.println( "===================== Строка: " + nums[ i ] );
            System.out.println( items.get( Integer.parseInt( nums[ i ] ) - 1 ) );
        }
    }
}