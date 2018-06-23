package ru.sbt.collections.third;

import ru.sbt.collections.Text;

import java.io.IOException;
import java.net.URISyntaxException;
/**
 * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 * java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.third.MainThirdTask
 */
public class MainThirdTask {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        ThirdTask task = new ThirdTask(Text.getWordsInArray());
        task.showUniqueWords();

    }
}
