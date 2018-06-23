package ru.sbt.collections.sixth;
import java.util.*;

public class SixthTask {
    String[] strings;
    HashMap<Integer, String> map;


    public SixthTask(String[] strings){

        this.strings = strings;
        this.map = this.createHashMap();
    }

    public int userOutput(){
        StringBuilder  sbuffer = new StringBuilder ();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number of string: ");
        sbuffer.append(input.nextLine());
        //оставляем только цифры
        String output = sbuffer.toString().replaceAll("[^0-9]+","");
        //проверяем если цифр нет, то присваиваем -1 чтобы далее завершить работу программы
        int n = ( output.length() != 0 ) ? Integer.parseInt(output) : -1;
        return n;
    }

    public HashMap<Integer, String> createHashMap(){
        HashMap<Integer,String> map = new HashMap<>();
        for(int i = 0; i < this.strings.length; i++){
            map.put(i, this.strings[i]);
        }
        return map;
    }

    public boolean isFoundString(int value){
        if( this.map.containsKey( value ) ){
            System.out.println( "Строка номер: " + value + ". Содержит: \"" + this.map.get( value )+"\"" );
            return true;
        }
        else{
            System.out.println( "Номера такой строки нет в документе.");
            return false;
        }
    }

    public void getNumberAndSearchString(){
        while ( this.isFoundString( this.userOutput() )){
            this.isFoundString( this.userOutput() );
        }
    }
}
