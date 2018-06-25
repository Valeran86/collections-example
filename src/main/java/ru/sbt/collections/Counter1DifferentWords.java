package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static String getString(String fileName) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream(fileName);
        return IOUtils.toString( resourceAsStream, "UTF8" );
        // "/ru/sbt/collections/VeryBigText.txt"
    }

    public static ArrayList<String> getStringArray(String fileName){
        // Массив строк
        ArrayList<String> strings = new ArrayList<>();

        try {
            // Странно, если тут пишу "/ru/sbt/collections/VeryBigText.txt" файл не находит
            // Пришлось хардкодить
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            strings.add(line);

            while (line != null) {
                //System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
                strings.add(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;



    }
    public static void main( String[] args ) throws IOException, URISyntaxException {

    }
}
