package com.company;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task3 {
    private Collection<String> collection;

    public Task3(Collection<String> collection) {
        this.collection = collection;
    }

    //Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
    //Необходимо отсортировать строки по возрастанию и добавить их в массив
    public void sort() {
        this.collection = collection.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .collect(Collectors.toList());
    }

    public Collection<String> getCollection() {
        return this.collection;
    }
}
