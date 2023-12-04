package com.company;

import java.util.Collection;

public class Task2 {
    //Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload».
    private Collection<String> collection;

    public Task2(Collection<String> collection) {
        this.collection = collection;
    }

    //Посчитать, сколько раз объект «High» встречается в коллекции
    public int task2_1() {
        return (int) collection.stream()
                .filter(x -> x.equals("High"))
                .count();
    }

    //Определить, какой элемент в коллекции находится на первом месте. Если мы получили пустую коллекцию, то пусть возвращается 0
    public String task2_2() {
        if (collection.isEmpty()) {
            return null;
        }
        return collection.stream()
                .findFirst().get();
    }

    //Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0
    public String task2_3() {
        if (collection.isEmpty()) {
            return null;
        }
        return collection.stream()
                .skip(collection.size() - 1)
                .findFirst().get();
    }

}
