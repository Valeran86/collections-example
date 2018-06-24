package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Counter1DifferentWords {
    private static PrintWriter outResult;

    public static void main( String[] args ) throws IOException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );

        outResult = new PrintWriter("result.txt");

        outResult.println("Исходный текст: ");
        outResult.println(lines);
        outResult.println();
        outResult.println("Задание 1: Подсчитайте количество различных слов в файле.");
        Set<String> uniqueWords=TaskOne(lines);
        outResult.println();
        outResult.println("Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.");
        TaskTwo(uniqueWords);
        outResult.println();
        outResult.println("Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.");
        TaskTree(getWords(lines));
        outResult.println();
        outResult.println("Задание 4: Выведите на экран все строки файла в обратном порядке.");
        TaskFour(lines);
        outResult.println();
        outResult.println("Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.");
        TaskFive(lines);
        outResult.println();
        outResult.println("Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        TaskSix(lines);

        outResult.close();
    }

    private static String[] getWords(String textFile){
        String textFileClear=textFile
                .replaceAll("[^А-Яа-яA-Za-z \\r\\n]", "")
                .replaceAll("[\\r\\n]"," ")
                .replaceAll("\\s+"," ");

        return  textFileClear.split(" ");
    }

//Задание 1: Подсчитайте количество различных слов в файле.
    private static Set<String> TaskOne(String textFile){
        String[] words=getWords(textFile);
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        outResult.println("Общее  количество слов:"+words.length);
        outResult.println("Количество уникальных слов:"+uniqueWords.size());
        return  uniqueWords;
    }


//Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
    private static void TaskTwo(Set<String> uniqueWords){
        TreeSet<String> treeSetComparable=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? 1 : -1;
            }
        });

        treeSetComparable.addAll(uniqueWords);
        for(String word:treeSetComparable){
            outResult.print(word+"["+word.length()+"]| ");
        }
        outResult.println("Контрольная сумма слов:"+treeSetComparable.size());
    }

//Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    private static void TaskTree (String[] words){
        HashMap<String,Integer> wordCountMap=new HashMap<>();
        for(String word:words){
            wordCountMap.merge(word,1,Integer::sum);
        }
        outResult.println(Collections.singletonList(wordCountMap));
    }

//Задание 4: Выведите на экран все строки файла в обратном порядке.
    private static void TaskFour(String textFile){
        String[] lines=textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);

        ListIterator<String> listIterator=wordLists.listIterator(wordLists.size());
        while (listIterator.hasPrevious()){
            outResult.println(listIterator.previous());
        }
    }
//Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
    private static void TaskFive(String textFile){
        String[] lines=textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);
        RevertIteratorList revertIteratorList=new RevertIteratorList(wordLists);
        Iterator<String> myIterator=revertIteratorList.iterator();

        while (myIterator.hasNext()) {
            outResult.println(myIterator.next());
        }
    }

//Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    private static void TaskSix(String textFile) {
        String[] lines = textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);

        Scanner in = new Scanner(System.in);
        System.out.println("Задайте номера строк через ;");
        String line=in.nextLine();
        outResult.println("Заданные номер строк: "+line);
        String[] numbers=line.replaceAll(" ","").split(";");
        int size_line=wordLists.size();
        for(String num:numbers){
            Integer n_line=valueInteger(num);
            if(n_line<0){
                outResult.println(num+" не является положительным целым числом");
                continue;
            }
            if (n_line>size_line){
                outResult.println(num+" больше количества строк в файле");
            }else{
                outResult.println(num+":"+wordLists.get(Integer.valueOf(num)-1));
            }
        }

    }

    private static Integer valueInteger(String num){
        try{
            return Integer.parseInt(num);
        }catch (NumberFormatException nfe){
            return -1;
        }
    }

}
