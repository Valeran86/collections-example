package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream( "/ru/sbt/collections/VeryBigText.txt" );
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );
        // System.out.println( lines );
        // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println( "Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле." );

        String reg = "[\\s ,; \\. ()—System.lineSeparator]";
        String[] words = lines.split( reg );

        HashMap< String, Integer > map = new HashMap< String, Integer >( );
        for ( String word2 : words ) {
            Integer frequency = map.get( word2 );
            int value = 1;
            if ( ( word2 != null ) && ( !word2.equals( "" ) ) ) {
                map.merge( word2, value, Integer::sum );
            }
        }
        for ( Map.Entry< String, Integer > pair : map.entrySet( ) ) {
            System.out.println( "Слово " + pair.getKey( ) + " встречается " + pair.getValue( ) + " раз" );
        }

        // Задание 4: Выведите на экран все строки файла в обратном порядке.
        System.out.println( "Задание 4: Выведите на экран все строки файла в обратном порядке." );
        ArrayList< String > lWords = new ArrayList< String >( );
        for ( String word1 : words ) {
            if ( ( word1 != null ) && ( !word1.equals( "" ) ) ) {
                lWords.add( word1 );
            }
        }
        for ( int i = lWords.size( ) - 1; i > -1; i-- ) {
            System.out.println( lWords.get( i ) );
        }

        // Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.

        System.out.println( "Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке." );
        ArrayList< String > reversList = new ArrayList< String >( );
        for ( String word : words ) {
            if ( ( word != null ) && ( !word.equals( "" ) ) ) {
                reversList.add( word );
            }
        }
        RIteraror iter = new RIteraror( reversList );
        while ( iter.hasPrevious( ) ) {
            System.out.println( iter.previous( ) );
        }

        //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        System.out.println( "Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке." );
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String[] strings = reader.readLine( ).split( "\\s" );
        ArrayList< Integer > userNum = new ArrayList<>( );
        try {
            for ( String string : strings ) {
                userNum.add( ( Integer.parseInt( string ) ) );
            }
            for ( Integer anUserNum : userNum ) {
                System.out.println( lWords.get( anUserNum ) );
            }
        }
        catch ( NumberFormatException e ) {
            System.out.println("Значения должны быть целыми числами!");
        }
        catch ( StringIndexOutOfBoundsException e ) {
            System.out.println( "Значения должны быть в диапазоне от 0 до " + words.length );
        }


    }
}






