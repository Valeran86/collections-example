package ru.sbt.collections;

import java.util.HashMap;
import java.util.Map;

public class CountMap<T> implements ICountMap<T> {

    private Map<T, Integer> map = new HashMap<>();

    public void add( T o ) {
        map.merge( o, 1, Integer::sum );
    }

    public int getCount( T o ) {
        return map.getOrDefault( o, 0 );
    }

    public int remove( T o ) {
        int cnt = map.get( o );
        map.remove( o );
        return cnt;
    }

    public int size() {
        return map.size();
    }

    public void addAll( ICountMap<T> source ) {
        for ( Map.Entry<T, Integer> entry : map.entrySet() ) {
            map.merge( entry.getKey(), entry.getValue(), Integer::sum );
        }
    }

    public Map toMap() {
        return new HashMap<>(map);
    }

    public void toMap( Map destination ) {
        destination.putAll(map);
    }
}