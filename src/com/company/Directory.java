package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров
public class Directory {
    private Map<String, ArrayList<String>> map = new HashMap<>();

    //В этот телефонный справочник с помощью метода add() можно добавлять записи
    public void add(String name, String phone) {
        if (!map.containsKey(name)) {
            ArrayList<String> list = new ArrayList<>(1);
            list.add(phone);
            map.put(name, list);
        } else {
            map.get(name).add(phone);
        }
    }

    //С помощью метода get() искать номер телефона по фамилии.
    //Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    //тогда при запросе такой фамилии должны выводиться все телефоны
    public String get(String name) {
        return Arrays.toString(map.get(name).toArray(new String[0]));
    }
}
