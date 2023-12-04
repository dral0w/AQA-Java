package com.company;

import java.util.Collection;

public class Task3 {
    private Collection<String> collection;

    public Task3(Collection<String> collection) {
        this.collection = collection;
    }

    //Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
    //Необходимо отсортировать строки по возрастанию и добавить их в массив
    public String[] sort() {
        Collection<String> result = collection.stream()
                .sorted((s1, s2) -> {
                    int num1 = Integer.parseInt(s1.substring(1));
                    int num2 = Integer.parseInt(s2.substring(1));
                    return Integer.compare(num1, num2);
                }).toList();
        return result.toArray(String[]::new);
    }

    public Collection<String> getCollection() {
        return this.collection;
    }
}
