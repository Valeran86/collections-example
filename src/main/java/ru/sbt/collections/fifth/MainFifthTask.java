package ru.sbt.collections.fifth;

import ru.sbt.collections.Text;

import java.io.IOException;
import java.net.URISyntaxException;
/**
 * Реализуйте свой Iterator для обхода списка в обратном порядке.
 * java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.fifth.MainFifthTask
 */
public class MainFifthTask {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        FifthTask task = new FifthTask(Text.getStringsInArray());
        task.showAllRevertStrings();
    }
}
