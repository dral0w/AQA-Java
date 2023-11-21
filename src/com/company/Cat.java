package com.company;

public class Cat extends Animal {
    private int runDistance = 200;
    private static int catsCount;
    private boolean fullness = false;

    public Cat() {
        super();
        catsCount++;
    }

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
        return catsCount;
    }

    public void eat(Plate plate, int food) {
        if (plate.getFood() >= food) {
            plate.takeFood(food);
            fullness = true;
        }
    }

    public boolean isFull() {
        return fullness;
    }

    public static class Plate {
        private static int food;

        public void addFood(int add) {
            food += add;
        }

        public int getFood() {
            return food;
        }

        public void takeFood(int count) {
            if (food >= count) {
                food -= count;
            }
        }
    }
}
