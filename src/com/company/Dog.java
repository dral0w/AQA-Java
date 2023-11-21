package com.company;

public class Dog extends Animal {
    private int runDistance = 500;
    private int swimDistance = 10;
    private static int dogsCount;

    public Dog() {
        super();
        dogsCount++;
    }

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
