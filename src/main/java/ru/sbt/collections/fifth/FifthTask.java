package ru.sbt.collections.fifth;

public class FifthTask{

    String[] strings;


    public FifthTask(String[] strings){

        this.strings = strings;
    }

    public void showAllRevertStrings(){
        ReversIterator<String> arrayStrings = new ReversIterator<>(this.strings);
        for(String string : arrayStrings) {
            System.out.println(string);
        }
    }

}
