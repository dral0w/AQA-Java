package com.company;

import java.util.*;

public class Task5 {
    Collection<String> collection = new ArrayList<>();

    public void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логины: ");
        while (true) {
            String login = scanner.nextLine();
            if (login.isEmpty()) {
                break;
            }
            collection.add(login);
        }

        String[] logins = collection.stream().filter(s -> s.startsWith("f")).toArray(String[]::new);
        System.out.println("Логины на букву f: ");
        for (String login : logins) {
            System.out.println(login);
        }
    }
}
