package ru.sbt.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class TaskWithCountMap {

    public static void main( String[] args )  {
        MyCountMup<Integer> map = new MyCountMup<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count5 = map.getCount(5);
        int count6 = map.getCount(6);
        int count10 = map.getCount(10);

        map.remove(6);

        count5 = map.getCount(5);
        count6 = map.getCount(6);
        count10 = map.getCount(10);

        int size=map.size();

        MyCountMup<Integer> myCountMup=new MyCountMup<>();
        myCountMup.add(3);
        myCountMup.add(5);
        myCountMup.add(5);
        myCountMup.add(5);

        map.addAll(myCountMup);

        int count3 = map.getCount(3);
        count5 = map.getCount(5);
        count6 = map.getCount(6);
        count10 = map.getCount(10);

        Map<Integer,Integer> mapII=map.toMap();

        Map<Integer,Integer> dest=new HashMap<>();
        map.toMap(dest);
        int sizeDest=dest.size();


    }
}
