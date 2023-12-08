package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров
public class Directory {
    private Map<String, String> map = new HashMap<>();

    //В этот телефонный справочник с помощью метода add() можно добавлять записи
    public void add(String phone, String name) {
        map.put(phone, name);
    }

    //С помощью метода get() искать номер телефона по фамилии.
    //Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    //тогда при запросе такой фамилии должны выводиться все телефоны
    public void get(String name) {
        System.out.println("Все номера телефонов для фамилии " + name +":");
        for (Map.Entry<String, String> user : map.entrySet()) {
            if (user.getValue().equals(name)) {
                System.out.println(user.getKey());
            }
        }
    }
}
