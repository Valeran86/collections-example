package ru.sbt.collections;

import java.util.HashMap;
import java.util.Map;

public class RealizeCountMap {
    public static void main(String [] args) {
        CountMap<Integer> mapMy = new CountMapIml<>();
        mapMy.add(10);
        mapMy.add(10);
        mapMy.add(5);
        mapMy.add(6);
        mapMy.add(5);
        mapMy.add(10);
        int count = mapMy.getCount(5);   // 2
        System.out.println("Количество цифр 5: "+ count);
        count = mapMy.getCount(6);   // 1
        System.out.println("Количество цифр 6: "+ count);
        count = mapMy.getCount(+10);  // 3
        System.out.println("Количество цифр 10: " + count);

        //Удаляет элемент из контейнера и возвращает количество его добавлений (до удаления)
        mapMy.remove(10);

        System.out.println("Список после удаления:"+ mapMy.toMap());

        //количество разных элементов
        System.out.println("Размер списка:"+ mapMy.size());

        //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
        CountMap<Integer> mapSource = new CountMapIml<>();
        mapSource.add(1);
        mapSource.add(5);
        mapSource.add(3);
        mapSource.add(3);
        mapMy.addAll(mapSource);

        //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
        System.out.println("Список после добавления из источника:" + mapMy.toMap());

        System.out.println("Переводим CountMap в Map: " +mapSource.toMap());
          //Тот же самый контракт как и toMap(), только всю информацию записать в destination
        Map<Integer, Integer> mapDestination = new HashMap<Integer, Integer>();
        mapDestination.put(5, 2);
        System.out.println("Содержимое Destination: " +mapDestination);
        mapMy.toMap(mapDestination);
        System.out.println("Содержимое mapDestination после слияния: " +mapDestination);
    }


}
