package ru.sbt.collections;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Reader {

    public static String[] readWords() throws IOException, URISyntaxException {
        return read("[\n\r .,()?;]");
    }
    public static String[] readLines() throws IOException, URISyntaxException {
        return read("\n");
    }
    private static String[] read(String pattern) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String lines = IOUtils.toString( resourceAsStream, "UTF8" );
        String[] words = lines.split(pattern);
        ArrayList<String> result = new ArrayList<>();
        for (String word: words) {
            if (!"".equals(word))
                result.add(word);
        }
        return result.toArray(new String[0]);
    }
}
