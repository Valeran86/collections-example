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

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );

        System.out.println( lines );
        task1(lines);
        task2(lines);
        task3(lines);
        task4(lines);
        task5(lines);
        task6(lines);

    }

    // return array of words from text
    private  static String [] text2words (String text) {
        return text.split("[- \f\n\r\t,.();]");
    }

   public static void task1 (String text){
        if (text == null)
            return ;
        // рефакторинг
       String[] words = text2words( text );
       Set<String> set = new HashSet<>( Arrays.asList( words  ) ) ;
       System.out.println( set.size()) ;
   }

    public static void task2 (String text){
        if (text == null) return   ;
        SortedSet <String> sortedSet = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                     int res = o1.length() - o2.length();
                     if (res==0)
                         return o1.compareTo(o2);
                     if (res>0)
                         return 1;
                     return -1;
                    }
                }
        );
        sortedSet.addAll(Arrays.asList(text2words (text)));
        for (String word: sortedSet) {
            System.out.println(word);
        }
    }
    public static void task3(String text) {
        if (text == null)
            return;
        HashMap <String, Integer> hs_word_count = new HashMap<>();

        for (String word:  text2words (text)) {
            hs_word_count.merge(word, 1,Integer::sum);
        }
        for ( Map.Entry <String, Integer> word: hs_word_count.entrySet()) {
            if (word.getValue() >1)
            System.out.println(word.getKey() + " " + word.getValue());
        }
    }

    public static void task4(String text) {
        // рефакторинг
        if (text == null)
            return;
        String [] textlines = text.split("[\n]");
        // Задача стоит вывести список в обратном порядке на экран, преобразование в список лишнее
        //   убираем преобразование  и выводим массив сразу в обратном порядке

        for ( int i = textlines.length-1;i>=0;i--){
            System.out.println(textlines[i]);
        }

    }

    public static void task5(String text) {

        if (text == null)
            return;
           class  InversIterator  <E> implements Iterator  {

            private int currentposition ;
            private List <E> list ;
            public InversIterator (List list ) {
                this.currentposition = list.size()-1;
                this.list = list;
            }

            @Override
            public boolean hasNext() {
                return  (currentposition >=0);
            }

            @Override
            public E next() {
                return  list.get(currentposition--);
            }
        }
        List <String> stringList = new ArrayList<>(Arrays.asList(text.split("[\n]"))) ;
        Iterator <String>  iterator = new InversIterator (stringList);

        while (iterator.hasNext())
            System.out.println(iterator.next());


    }

    public static void task6 (String text){
        if (text.isEmpty()) return;
        List <String> stringList = new ArrayList<>(Arrays.asList(text.split("[\n]")));
        int linenumber ;
        Scanner consoleinput = new Scanner(System.in);
       while (true) {
           System.out.println("Введите номер строки для вывода текста в пределах от 1 до " + stringList.size() + " для выхода введите 0");
           linenumber = consoleinput.nextInt();
           if (!(linenumber >0 && linenumber <= stringList.size()))
               break ;
           System.out.println(stringList.get(linenumber-1));
       }

    }


}
