package com.company;

public class Animal {
    private static int animalsCount;

    public Animal() {
        animalsCount++;
    }

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
