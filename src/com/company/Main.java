package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        //Задание 1
        Task1 task1 = new Task1(10);
        System.out.println(Arrays.toString(task1.getNumbers()));
        System.out.println(task1.findEvenNumbers());

        //Задание 2
        Collection<String> collection = new ArrayList<>();

        collection.add("Highload");
        collection.add("High");
        collection.add("Load");
        collection.add("Highload");

        Task2 task2 = new Task2(collection);

        System.out.println(task2.task2_1());
        System.out.println(task2.task2_2());
        System.out.println(task2.task2_3());

        //Задание 3
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("f10");
        collection1.add("f15");
        collection1.add("f2");
        collection1.add("f4");
        collection1.add("f4");

        Task3 task3 = new Task3(collection1);

        System.out.println(task3.getCollection());

        task3.sort();

        System.out.println(task3.getCollection());

        //Задание 4
        Task4 task4 = new Task4();

        System.out.println(task4.task4_1());
        System.out.println(task4.task4_2());

        //Задание 5
        Task5 task5 = new Task5();
        task5.task5();
    }
}
