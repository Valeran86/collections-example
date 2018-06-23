package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;

//Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
public class Iterator {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        MyList words = new MyList(Reader.readWords());
        for (String word: words) {
            System.out.println(word);
        }
    }
    public static class MyList implements Iterable<String> {

        private final String[] arrayList;

        public MyList(String[] newArray) {
            this.arrayList = newArray;
        }

        @Override
        public java.util.Iterator<String> iterator() {
            return new java.util.Iterator<String>() {
                private int current = arrayList.length -1;
                @Override
                public boolean hasNext() {
                    return current > 0;
                }

                @Override
                public String next() {
                    return arrayList[--current];
                }
            };
        }
    }

}
