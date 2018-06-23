package ru.sbt.collections.sixth;

import ru.sbt.collections.Text;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
 * java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.sixth.MainSixthTask
 */
public class MainSixthTask {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        SixthTask task = new SixthTask(Text.getStringsInArray());
        task.getNumberAndSearchString();
    }
}
