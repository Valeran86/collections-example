package ru.sbt.collections.first;

import ru.sbt.collections.Text;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Подсчитайте количество различных слов в файле.
 * java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.first.MainFirstTask
 */
public class MainFirstTask {
    public static void main( String[] args ) throws IOException, URISyntaxException {

        FirstTask task = new FirstTask(Text.getWordsInArray());
        task.printCountWordsFromArray();
        task.printCountUniqueSizeWords();
    }
}
