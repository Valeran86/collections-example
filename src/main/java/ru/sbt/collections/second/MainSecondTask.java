package ru.sbt.collections.second;


import ru.sbt.collections.Text;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 * Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
 * java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.second.MainSecondTask
 */

public class MainSecondTask {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        SecondTask task = new SecondTask(Text.getWordsInArray());
        task.getSortedArrayWordsToLength();
    }
}
