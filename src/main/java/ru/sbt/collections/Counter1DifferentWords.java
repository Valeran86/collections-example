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

        task1(lines); System.out.println("-------------------------------------------");
        task2(lines); System.out.println("-------------------------------------------");
        task3(lines); System.out.println("-------------------------------------------");
        task4(lines); System.out.println("-------------------------------------------");
        task5(lines); System.out.println("-------------------------------------------");
        task6(lines); System.out.println("-------------------------------------------");


    }

    private static String[] text2words(String text) {
        return text.split("[\n\t\f\r,.!?;:() —/]");
    }

    public static void task1(String text) {
        if ( text == null ) return;

        ArrayList<String> al = new ArrayList<>(Arrays.asList(text2words(text)));
        HashSet<String> hs = new HashSet(al);

        System.out.println("Количество слов (различных/с повторами): " + hs.size() + "/" + al.size());
    }


    public static void task2(String text) {
        if ( text == null ) return;

        List<String> list = new ArrayList<>(new HashSet<>(Arrays.asList(text2words(text))));
        list.sort((first, second) -> Integer.compare(first.length(), second.length()));

        int count = 0;
        for ( String temp : list ) {
            count++;
            System.out.println("" + count + ") " + temp + " (длина " + temp.length() + ")" );
        }
    }

    public static void task3(String text) {
        if ( text == null ) return;

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                else{
                    return s1.compareTo(s2);
                }
            }
        };

        TreeMap<String, Integer> tm = new TreeMap<>(comp); //byLengthComp.thenComparing(byABCComp) (не понадобилось)

        for ( String word : text2words(text) ) {
            tm.merge(word, 1, Integer::sum);
        }

        int count = 0;
        for ( Map.Entry<String, Integer> word : tm.entrySet() ) {
            count++;
            System.out.println("" + count + ") " + word.getKey() + " (" + word.getValue() + " раз)");
        }
    }

    public static void task4(String text) {
        if ( text == null ) return;
        List<String> list = new ArrayList<>(Arrays.asList(text.split("[\n]")));
        for ( int i = (list.size() - 1); i >= 0; i-- ) {
            System.out.println("" + (i + 1) + ") " + list.get(i));
        }
    }

    public static void task5(String text) {

        class InversionIterator<E> implements Iterator {

            private int currentposition;
            private List<E> list;

            public InversionIterator(List<E> list) {
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

        List<String> list = new ArrayList<>(Arrays.asList(text.split("[\n]")));

        int line_number;
        Scanner scan = new Scanner(System.in);
        while ( true ) {
            System.out.println("Укажите номер строки для вывода (от 1 до " + list.size() + "). Для выхода введите 0:");
            line_number = scan.nextInt();
            if ( !(line_number > 0 && line_number <= list.size()) )
                break;
            System.out.println(list.get(line_number - 1) + "\n");
        }

    }


}