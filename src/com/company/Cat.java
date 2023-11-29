package com.company;

//Создать классы Собака и Кот с наследованием от класса Животное.
public class Cat extends Animal {
    private int runDistance = 200;
    private static int catsCount;

    //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    private boolean fullness = false;

    //Добавить подсчет созданных котов.
    public Cat() {
        super();
        catsCount++;
    }

    //У каждого животного есть ограничения на действия (бег: кот 200 м.; плавание: кот не умеет плавать).
    @Override
    public void run(int distance) {
        if (runDistance > distance) {
            runDistance -= distance;
            System.out.println("Кот пробежал " + distance + "м");
        } else {
            System.out.println("Кот может пробежать только " + runDistance + "м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

    public static int getCatsCount() {
        System.out.println("Всего котов: " + catsCount);
        return catsCount;
    }

    //Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
    public void eat(com.company.Plate plate, int food) {
        if (plate.getFood() >= food) {
            plate.takeFood(food);
            fullness = true;
        } else {
            System.out.println("В тарелке недостаточно еды");
        }
    }

    public boolean isFull() {
        return fullness;
    }
}
