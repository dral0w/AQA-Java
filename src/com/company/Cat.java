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
        return catsCount;
    }

    //Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
    public void eat(Plate plate, int food) {
        if (plate.getFood() >= food) {
            plate.takeFood(food);
            fullness = true;
        }
    }

    public boolean isFull() {
        return fullness;
    }

    //Расширить задачу про котов и тарелки с едой
    public static class Plate {
        private static int food;

        //Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
        public void addFood(int add) {
            food += add;
        }

        public int getFood() {
            return food;
        }

        //Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
        public void takeFood(int count) {
            if (food >= count) {
                food -= count;
            }
        }
    }
}
