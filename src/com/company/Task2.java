package com.company;

import java.util.Collection;

public class Task2 {
    private Collection<String> collection;

    public Task2(Collection<String> collection) {
        this.collection = collection;
    }

    public int task2_1() {
        return (int)collection.stream()
                .filter(x -> x.equals("High"))
                .count();
    }

    public String task2_2() {
        if (collection.isEmpty()) {
            return null;
        }
        return collection.stream()
                .findFirst().get();
    }

    public String task2_3() {
        if (collection.isEmpty()) {
            return null;
        }
        return collection.stream()
                .skip(collection.size() - 1)
                .findFirst().get();
    }

}
