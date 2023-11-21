package com.company;

//Создать классы Собака и Кот с наследованием от класса Животное.
public class Dog extends Animal {
    private int runDistance = 500;
    private int swimDistance = 10;
    private static int dogsCount;

    //Добавить подсчет созданных собак.
    public Dog() {
        super();
        dogsCount++;
    }

    //У каждого животного есть ограничения на действия (бег: собака 500 м.; плавание: собака 10 м.).
    @Override
    public void run(int distance) {
        if (runDistance > distance) {
            runDistance -= distance;
            System.out.println("Собака пробежала " + distance + "м");
        } else {
            System.out.println("Собака может пробежать только " + runDistance + "м");
        }
    }

    @Override
    public void swim(int distance) {
        if (swimDistance > distance) {
            swimDistance -= distance;
            System.out.println("Собака проплыла " + distance + "м");
        } else {
            System.out.println("Собака может проплыть только " + swimDistance + "м");
        }
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
