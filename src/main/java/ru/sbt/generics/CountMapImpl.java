package ru.sbt.generics;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private HashMap<T, Integer> holder = new HashMap<>();

    /**
     * добавляет элемент в этот контейнер.
     *
     * @param o
     */
    @Override
    public void add(T o){
        this.holder.merge(o,1, Integer::sum);
    }

    /**
     * @param o
     * @return количество добавлений данного элемента
     */
    @Override
    public int getCount(T o){
        return this.holder.get(o);
    }

    /**
     * Удаляет элемент из контейнера
     *
     * @param o
     * @return количество его добавлений (до удаления)
     */
    @Override
    public int remove(T o){
        return this.holder.remove(o);
    }

    /**
     * @return количество разных элементов
     */
    @Override
    public int size(){
        return this.holder.size();
    }

    /**
     * Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
     *
     * @param source
     */
    @Override
    public void addAll(CountMap<T> source){
    }

    /**
     * @return Map, где ключ - добавленный элемент, значение - количество его добавлений
     */
    @Override
    public Map<T, Integer> toMap(){
        return this.holder;
    }

    /**
     * Тот же самый контракт как и toMap(), только всю информацию записать в destination
     *
     * @param destination
     */
    @Override
    public void toMap(Map<T, Integer> destination) {
        destination = new HashMap<>();
        for (Map.Entry<T, Integer> entry : this.holder.entrySet()) {
            destination.put(entry.getKey(), entry.getValue());
        }
    }
}
