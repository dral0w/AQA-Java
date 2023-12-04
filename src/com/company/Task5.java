package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

//Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
//Как только пользователь введет пустую строку - программа должна прекратить приём данных от пользователя
//и вывести в консоль логины, начинающиеся на букву f (строчную).
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
