package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        String[] words = new String[] {"apple", "banana", "cherry", "apple", "grape",
                "banana", "orange", "apple", "banana", "cherry"};
        Set<String> set = new HashSet<>(Arrays.asList(words));

        System.out.println("Список уникальных слов: ");
        for (String word : set) {
            System.out.println(word);
        }

        System.out.println("Количество повторений: ");
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
        System.out.println(wordsCount.entrySet());

        Directory directory = new Directory();
        directory.add("1", "Иванов");
        directory.add("2", "Петров");
        directory.add("3", "Сидоров");
        directory.add("4", "Иванов");
        directory.add("5", "Иванов");
        directory.add("6", "Иванов");
        directory.add("7", "Сидоров");
        directory.get("Иванов");

    }
}
