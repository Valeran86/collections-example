package ru.sbt.generics;

import java.util.*;

public class CountMap <T> implements CountableMap <T> {

    private Map<T, Integer> userMap = new HashMap<>();

    // добавляет элемент в этот контейнер.
    public void add(T o){
        userMap.put( o, userMap.getOrDefault( o, 0) + 1 );
    }

    //Возвращает количество добавлений данного элемента
    public int getCount( T o){
        if( userMap.containsKey(o) ){
            return userMap.get(o);
        }else{
            return 0;
        }
    }

    //Удаляет элемент из контейнера и возвращает количество его добавлений (до удаления)
    public int remove( T o ){
        int countBeforeRemove = this.getCount( o );
        if( countBeforeRemove != 0 )
            userMap.remove( o );
        return countBeforeRemove;
    }

    //количество разных элементов
    public int size(){
        return userMap.size();
    }

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,  суммировать значения
    public void addAll( CountMap <T> source ){
        source.userMap.forEach( (k, v) -> userMap.merge( k, v, Integer::sum) );
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    public Map<T, Integer> toMap(){
        return userMap;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    public void toMap( Map <T, Integer> destination ){
        destination.clear();
        destination.putAll( userMap );
    }
}
