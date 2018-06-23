package ru.sbt.collections.fourth;

import ru.sbt.collections.Text;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Выведите на экран все строки файла в обратном порядке.
 * java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.fourth.MainFourthTask
 */
public class MainFourthTask {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        FourthTask task = new FourthTask(Text.getStringsInArray());
        task.showRevertString();
    }
}
