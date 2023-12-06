package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("apple");
        words.add("grape");
        words.add("banana");
        words.add("orange");
        words.add("apple");
        words.add("banana");
        words.add("cherry");

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                int count = wordsCount.get(word);
                wordsCount.put(word, ++count);
            }
        }

        //Найти и вывести список уникальных слов, из которых состоит массив. Посчитать, сколько раз встречается каждое слово
        List<String> uniqueWords = new ArrayList<>(wordsCount.keySet());

        for (String word : uniqueWords) {
            int count = wordsCount.get(word);
            System.out.println(count + " " + word);
        }

        Directory directory = new Directory();
        directory.add("Иванов", "123456");
        directory.add("Петров", "1234567");
        directory.add("Сидоров", "123456");
        directory.add("Иванов", "111111");
        directory.add("Иванов", "111111");
        directory.add("Иванов", "111111");
        directory.add("Сидоров", "123456");
        System.out.println(directory.get("Иванов"));
    }
}
