package ru.sbt.collections;

import java.util.HashMap;
import java.util.Map;


public class MyCountMup<T> implements CountMap<T> {
    private Map<T,Integer> myMap=new HashMap<>();

    @Override
    public void add(T o) {
        if(!myMap.containsKey(o)){
            myMap.put(o,1);
        }else{
            myMap.put(o,myMap.get(o)+1);
        }
    }

    @Override
    public int getCount(T o) {
        return myMap.getOrDefault(o, 0); //myMap.containsKey(o)?myMap.get(o):0;
    }

    @Override
    public int remove(T o) {
        Integer countObj=0;
        if(myMap.containsKey(o)){
            countObj=myMap.get(o);
            if(countObj>1){
                myMap.put(o,myMap.get(o)-1);
            }else{
                myMap.remove(o);
            }
        }
        return countObj;
    }

    @Override
    public int size() {
        return myMap.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for(Map.Entry<T, Integer> entry:source.toMap().entrySet()){
            if(myMap.containsKey(entry.getKey())){
                myMap.put(entry.getKey(), myMap.get(entry.getKey())+entry.getValue());
            }else{
                myMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return myMap;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(myMap);
    }

}
