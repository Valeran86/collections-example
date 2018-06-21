package ru.sbt.collections;


import com.sun.xml.internal.ws.util.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 */
public class Counter1DifferentWords {
    private static PrintWriter outResult;


    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );

        outResult = new PrintWriter("result.txt");

        System.out.println("Исходный текст: ");
        outResult.println("Исходный текст: ");
        System.out.println( lines );
        outResult.println(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 1: Подсчитайте количество различных слов в файле.");
        Set<String> uniqueWords=TaskOne(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.");
        TaskTwo(uniqueWords);
        System.out.println();
        outResult.println();
        outResult.println("Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.");
        TaskTreeImplTwo(getWords(lines));
        System.out.println();
        outResult.println();
        outResult.println("Задание 4: Выведите на экран все строки файла в обратном порядке. Реализация 1.");
        TaskFourImplOne(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 4: Выведите на экран все строки файла в обратном порядке. Реализация 2.");
        TaskFourImplTwo(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.");
        TaskFive(lines);
        System.out.println();
        outResult.println();
        outResult.println("Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        TaskSix(lines);

        outResult.close();
    }

    private static  String[] getWords(String textFile){
        String textFileClear=textFile
                .replaceAll("[^А-Яа-яA-Za-z \\r\\n]", "")
                .replaceAll("[\\r\\n]"," ")
                .replaceAll("\\s+"," ");

        return  textFileClear.split(" ");
    }

//Задание 1: Подсчитайте количество различных слов в файле.
    private static Set<String> TaskOne(String textFile){
        String[] words=getWords(textFile);

        HashMap<String,Integer> wordCountMap=new HashMap<>();

        Set<String> uniqueWords=new HashSet<>();
        for(String word:words){
            if(uniqueWords.add(word)){
                wordCountMap.put(word,1);
            }else{
                wordCountMap.put(word,wordCountMap.get(word)+1);
            }
        }
        System.out.println("Общее  количество слов:"+words.length);
        outResult.println("Общее  количество слов:"+words.length);
        System.out.println("Количество уникальных слов:"+uniqueWords.size());
        outResult.println("Количество уникальных слов:"+uniqueWords.size());

//Реализация 3-его задания с использованием уже имеющегося подходящего функционала
//TODO Выводить не стал, т.к. не по порядку. Но надо прочитать что более ресурсоемко set.add или hashmap.containsKey
//        TaskTreeOut(wordCountMap);

        return  uniqueWords;
    }


//Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
    private static void TaskTwo(Set<String> uniqueWords){
        TreeSet<TaskTwoComporable> taskTwoComporables=new TreeSet<>();
        for(String word: uniqueWords){
            TaskTwoComporable t=new TaskTwoComporable(word);
            taskTwoComporables.add(t);
        }
        for(TaskTwoComporable taskTwoComporable:taskTwoComporables){
            String word=taskTwoComporable.getWord();
            System.out.print(word+"["+word.length()+"]| ");
            outResult.println(word+"["+word.length()+"]| ");
        }
        System.out.println();
        outResult.println();
        System.out.println("Контрольная сумма слов:"+taskTwoComporables.size());
        outResult.println("Контрольная сумма слов:"+taskTwoComporables.size());
    }

    static class TaskTwoComporable implements Comparable<TaskTwoComporable>{
        private String wordComporable;

        public TaskTwoComporable(String word) {
            this.wordComporable = word;
        }

        public String getWord() {
            return wordComporable;
        }

        @Override
        public int compareTo(TaskTwoComporable o) {
            int result=wordComporable.length()-o.getWord().length();
            return (result==0)?-1:result;
        }
    }

//Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    private static void TaskTreeImplTwo (String[] words){
        HashMap<String,Integer> wordCountMap=new HashMap<>();
        for(String word:words){
            if(wordCountMap.containsKey(word)){
                wordCountMap.put(word,wordCountMap.get(word)+1);
            }else{
                wordCountMap.put(word,1);
            }
        }
        TaskTreeOut(wordCountMap);
    }

    private static void TaskTreeOut (HashMap<String,Integer> wordCountMap){
        Integer controlCountWords=0;
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
            outResult.println(entry.getKey()+"-"+entry.getValue());
            controlCountWords+=entry.getValue();
        }
        System.out.println("Контрольная сумма слов:"+controlCountWords);
        outResult.println("Контрольная сумма слов:"+controlCountWords);
    }


//Задание 4: Выведите на экран все строки файла в обратном порядке.
    private static void TaskFourImplOne(String textFile){
        String[] lines=textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);
        Collections.reverse(wordLists);

        System.out.println("Исходный текст: ");
        outResult.println("Исходный текст: ");
        System.out.println(textFile);
        outResult.println(textFile);
        System.out.println("Текст в обратном порядке: ");
        outResult.println("Текст в обратном порядке: ");
        for(String wordList:wordLists){
            System.out.println(wordList);
            outResult.println(wordList);
        }
    }
//Задание 4: Выведите на экран все строки файла в обратном порядке. С испорльзованием Итератора
    private static void TaskFourImplTwo(String textFile){
        String[] lines=textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);

        System.out.println("Исходный текст: ");
        outResult.println("Исходный текст: ");
        System.out.println(textFile);
        outResult.println(textFile);
        System.out.println("Текст в обратном порядке: ");
        outResult.println("Текст в обратном порядке: ");
        ListIterator<String> listIterator=wordLists.listIterator(wordLists.size());
        while (listIterator.hasPrevious()){
            String res=listIterator.previous();
            System.out.println(res);
            outResult.println(res);
        }
    }

    private static void TaskFive(String textFile){
        String[] lines=textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);

        System.out.println("Исходный текст: ");
        outResult.println("Исходный текст: ");
        System.out.println(textFile);
        outResult.println(textFile);
        System.out.println("Текст в обратном порядке: ");
        outResult.println("Текст в обратном порядке: ");

        MyList myList=new MyList(wordLists);
        ListIterator<String> myIterator=myList.iterator();

        while (myIterator.hasPrevious()){
            String res=myIterator.previous();
            System.out.println(res);
            outResult.println(res);
        }
    }





//Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    private static void TaskSix(String textFile) {
        String[] lines = textFile.split("[\\r\\n]+");
        List<String> wordLists = Arrays.asList(lines);

        Scanner in = new Scanner(System.in);
        System.out.println("Введите номера строк которые хотите отобразить через разделитель ;");
        outResult.print("Заданные номер строк:");
        String line=in.nextLine();
        outResult.println(line);
        String[] numbers=line.replaceAll(" ","").split(";");
        for(String num:numbers){
            if(!isInteger(num)){
                System.out.println(num+" не является целым числом");
                outResult.println(num+" не является целым числом");
                continue;
            }

            if(Integer.valueOf(num)>wordLists.size()){
                System.out.println(num+" больше количества строк в файле");
                outResult.println(num+" больше количества строк в файле");
            }else if(Integer.valueOf(num)<1){
                System.out.println(num+" номер строки должен быть больше ноля");
                outResult.println(num+" номер строки должен быть больше ноля");
            } else {
                System.out.println(num+":"+wordLists.get(Integer.valueOf(num)-1));
                outResult.println(num+":"+wordLists.get(Integer.valueOf(num)-1));
            }
        }

    }

    private static boolean isInteger(String num){
        try{
            Integer.parseInt(num);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

}
