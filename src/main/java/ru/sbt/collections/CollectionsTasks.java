package ru.sbt.collections;
import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CollectionsTasks {
    private String text;
    private List<String> words;
    private List<String> lines;

    public CollectionsTasks(String text) {
        this.text = text;
        //this.words = this.text.split("[a-zA-zа-яА-Я0-9]+");
        this.words = Pattern.compile("[a-zA-zа-яА-Я0-9]+")
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        this.lines = Arrays.asList(text.split("\r\n"));
    }

    /**
     * Задание 1: Подсчитайте количество различных слов в файле.
     *
     * @return amount of different words
     */
    public int DifferentWords() {
        HashSet<String> set = new HashSet<String>(words);
        return set.size();
    }

    /**
     * Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
     *
     * @return amount of different words
     */
    public int SortedWords() {
        TreeSet<String> sorted = new TreeSet<String>((s1, s2) -> {
            int difference = s1.length() - s2.length();
            return difference == 0 ? String.CASE_INSENSITIVE_ORDER.compare(s1, s2) : difference;
        });
        sorted.addAll(words);
        sorted.forEach(System.out::println);
        return sorted.size();
    }

    /**
     * Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
     */
    public void CountUses() {
        HashMap<String, Integer> uses = new HashMap<>();
        words.forEach(word -> uses.merge(word, 1, Integer::sum));
        uses.entrySet().forEach(System.out::println);
    }

    /**
     * Задание 4: Выведите на экран все строки файла в обратном порядке.
     */
    public void reverseLines() {
        Stack<String> stack = new Stack<>();
        stack.addAll(lines);
        while (!stack.empty())
            System.out.println(stack.pop());
    }

    /**
     * Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
     */
    public void checkIterator() {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = Arrays.asList(array);
        Iterator iterator = new ExoticIterator<Integer>(list);
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    /**
     * Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
     */
    public void showSpecifiedLines() {
        Scanner input = new Scanner(System.in);
        int maxIndex = lines.size() - 1;
        System.out.println("Enter line number (from 0 to " + maxIndex + "), or something else to quit");
        while (true) {
            try {
                int index = input.nextInt();
                if (maxIndex < index || index < 0)
                    break;

                System.out.println(lines.get(index));
            } catch (Throwable exception) {
                break;
            }
        }
    }
}
