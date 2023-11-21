package com.company;

public class Animal {
    private static int animalsCount;

    //Добавить подсчет созданных животных.
    public Animal() {
        animalsCount++;
    }

    //Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + "м");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + "м");
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }
}
