package ru.sbt.collections;


import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Подсчитайте количество различных слов в файле.
 *     Задание 1: Подсчитайте количество различных слов в файле .
 *     Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
 *     Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 *     Задание 4: Выведите на экран все строки файла в обратном порядке.
 *     Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
 *     Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
 */

public class Counter1DifferentWords {

    public static void main(String[] args) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString(resourceAsStream, "UTF8");

        task1(lines);  System.out.println("-------------------------------------------");
        task2(lines);  System.out.println("-------------------------------------------");
        task3(lines);  System.out.println("-------------------------------------------");
        task4(lines);  System.out.println("-------------------------------------------");
        task5(lines);  System.out.println("-------------------------------------------");
        task6(lines);  System.out.println("-------------------------------------------");

    }

    private static String[] text2words(String text) {
        return text.split("[\n\t\f\r,.!?;:() —/]");
    }

/*  увы, не успел с компараторами

    static class StringLengthComparator implements Comparator<String> {

        public int compare(String first, String second) {

            int res = first.length() - second.length();
            if ( res == 0 ) return 0;
            if ( res > 0 ) return 1;
            return -1;
        }
    }

    //static class StringABCComparator implements Comparator<String> {}
*/

    public static void task1(String text) {
        if ( text == null ) return;

        ArrayList<String> al = new ArrayList<>(Arrays.asList(text2words(text)));
        HashSet<String> hs = new HashSet(al);

        System.out.println("Количество слов (различных/с повторами): " + hs.size() + "/" + al.size());
    }

    public static void task2(String text) {
        if ( text == null ) return;

        HashSet<String> hs = new HashSet<>(Arrays.asList(text2words(text)));

        //определяем интервал для длин слов
        int minLength = 1001, maxLength = -1;
        for ( String temp : hs ) {
            if ( temp.length() > maxLength ) {
                maxLength = temp.length();
            }
            if ( temp.length() < minLength ) {
                minLength = temp.length();
            }
        }

        System.out.println();

        // последовательно отбираем группы слов одинаковой длины
        int serialNumberWord = 0;
        for ( int lengthWord = minLength; lengthWord <= maxLength; lengthWord++ ) {
            for ( String word : hs ) {
                if ( word.length() == lengthWord ) {
                    serialNumberWord++;
                    System.out.println("" + serialNumberWord + ") " + word + " (" + lengthWord + " символов)");
                }
            }
        }
    }

    public static void task3(String text) {
        if ( text == null ) return;

        TreeMap<String, Integer> tm = new TreeMap<>();

        for ( String word : text2words(text) ) {
            tm.merge(word, 1, Integer::sum);
        }

        int minLength = 1001, maxLength = -1;
        for ( Map.Entry<String, Integer> word : tm.entrySet() ) {
            int word_length = word.getKey().length();
            if ( word_length > maxLength ) {
                maxLength = word_length;
            }
            if ( word_length < minLength ) {
                minLength = word_length;
            }
        }

        // последовательно отбираем группы слов одинаковой длины
        int serialNumberWord = 0;
        for ( int lengthWord = minLength; lengthWord <= maxLength; lengthWord++ ) {
            for ( Map.Entry<String, Integer> word : tm.entrySet() ) {
                if ( word.getKey().length() == lengthWord ) {
                    serialNumberWord++;
                    System.out.println("" + serialNumberWord + ") " + word.getKey() + " (" + word.getValue() + " раз)");
                }
            }
        }
    }

    public static void task4(String text) {
        if ( text == null ) return;
        List<String> al = new ArrayList<>(Arrays.asList(text.split("[\n]")));
        for ( int i = ( al.size() - 1 ); i >= 0; i-- ) {
            System.out.println("" + (i + 1) + ") " + al.get(i));
        }
    }

    public static void task5(String text) {

        class InversionIterator<E> implements Iterator {

            private int currentposition;
            private List<E> list;

            public InversionIterator(List list) {
                this.currentposition = list.size() - 1;
                this.list = list;
            }

            @Override
            public boolean hasNext() {
                return (currentposition >= 0);
            }

            @Override
            public E next() {
                return list.get(currentposition--);
            }
        }
    }

    public static void task6(String text) {
        if ( text.isEmpty() ) return;

        List<String> al = new ArrayList<>(Arrays.asList(text.split("[\n]")));

        int line_number;
        Scanner scan = new Scanner(System.in);
        while ( true ) {
            System.out.println("Укажите номер строки для вывода (от 1 до " + al.size() + "). Для выхода введите 0:");
            line_number = scan.nextInt();
            if ( !(line_number > 0 && line_number <= al.size()) )
                break;
            System.out.println(al.get(line_number - 1) + "\n");
        }

    }


}