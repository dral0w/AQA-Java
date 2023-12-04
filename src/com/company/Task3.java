package com.company;

import java.util.Collection;

public class Task3 {
    private Collection<String> collection;

    public Task3(Collection<String> collection) {
        this.collection = collection;
    }

    public String[] sort() {
        this.collection = collection.stream()
                .sorted((s1, s2) -> {
                    int num1 = Integer.parseInt(s1.substring(1));
                    int num2 = Integer.parseInt(s2.substring(1));
                    return Integer.compare(num1, num2);
                }).toList();
        return collection.toArray(String[]::new);
    }

    public Collection<String> getCollection() {
        return this.collection;
    }
}
