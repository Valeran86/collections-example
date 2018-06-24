package ru.sbt.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskPECS {

    public static void main( String[] args ) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        List<AsianApple> applesAsia = new ArrayList<>();
        applesAsia.add(new AsianApple());
        applesAsia.add(new AsianApple());
        applesAsia.add(new AsianApple());

        List<Fruit> fruit = new ArrayList<>();
        fruit.add(new Fruit());

        System.out.println("Исходные: "+apples.size());
        System.out.println("Исходные: "+applesAsia.size());

        CollectionUtils.addAll(applesAsia,apples); //Источник, Получатель
        System.out.println("addAll: "+apples.size());
        System.out.println("addAll: "+applesAsia.size());

        List<? super Fruit> superFruits=CollectionUtils.newArrayList(apples);
        System.out.println("newArrayListApples: "+superFruits.size());
        superFruits=CollectionUtils.newArrayList(applesAsia);
        System.out.println("newArrayListApplesAsia: "+superFruits.size());
        superFruits=CollectionUtils.newArrayList(fruit);
        System.out.println("newArrayListFruit: "+superFruits.size());

        Apple apple=new Apple();
        superFruits.add(apple);
        int iApple=CollectionUtils.indexOf(superFruits, apple);
        System.out.println("indexOf: "+iApple);

        superFruits=CollectionUtils.limit(apples,2);
        System.out.println("limit-2: "+superFruits.size());
        superFruits=CollectionUtils.limit(apples,0);
        System.out.println("limit-0: "+superFruits.size());
    //    superFruits=CollectionUtils.limit(apples,-1);    java.lang.IllegalArgumentException: -1<0

        CollectionUtils.add(apples,new Apple());
        System.out.println("add: "+apples.get(apples.size()-1).toString());

        System.out.println("removeAll, до добавления 4-х одинаковых объектов: "+apples.size());
        apples.add(apple);
        apples.add(apple);
        apples.add(apple);
        apples.add(apple);
        System.out.println("removeAll, после добавления 4-х одинаковых объектов: "+apples.size());
        CollectionUtils.removeAll(apples,apple);
        System.out.println("removeAll, после удаления объекта: "+apples.size());

        Apple apple2=new Apple();
        AsianApple asianApple1=new AsianApple();
        Fruit fruit1=new Fruit();

        List<? super Fruit> superFruits1=new ArrayList<>();
        superFruits1.add(apple);
        superFruits1.add(apple2);
        superFruits1.add(asianApple1);
        superFruits1.add(fruit1);
        List<? super Fruit> superFruits2=CollectionUtils.newArrayList(superFruits1);

        boolean result=CollectionUtils.containsAll(superFruits1,superFruits2);
        System.out.println("containsAll true: "+result);

        AsianApple asianApple2=new AsianApple();
        superFruits2.add(asianApple2);

        result=CollectionUtils.containsAll(superFruits1,superFruits2);
        System.out.println("containsAll false: "+result);

        List<? super Fruit> superFruits3=new ArrayList<>();
        superFruits3.add(asianApple2);
        result=CollectionUtils.containsAny(superFruits1,superFruits2);
        System.out.println("containsAny true: "+result);
        result=CollectionUtils.containsAny(superFruits1,superFruits3);
        System.out.println("containsAny false: "+result);

        List<? super Integer> numberList1=CollectionUtils.range(Arrays.asList(8,1,3,5,6,4),3,6);
        System.out.println("range: "+numberList1);

        Comparator<Integer> myComparator=new ComparatorMy<>();
        List<? super Integer> numberList2=CollectionUtils.range(Arrays.asList(8,1,3,5,6,4),3,6,myComparator);
        System.out.println("rangeComparator: "+numberList2);
    }

    static class  ComparatorMy<T> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.hashCode()-o2.hashCode();
        }
    }
}
