package ru.sbt.collections.fourth;


import java.util.*;

public class FourthTask {

    String[] strings;

    public FourthTask(String[] strings){

        this.strings = strings;
    }

    public TreeSet<String> revertData()
    {
        TreeSet<String> strings = new TreeSet<String>();
        Collections.addAll(strings, this.strings);
        strings.descendingSet();
        return strings;
    }

    public void showRevertString(){
        System.out.println("Обратный порядок строк " + this.revertData());
    }
}
