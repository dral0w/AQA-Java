package com.company;

public class Plate {
    private int food;

    //Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void addFood(int add) {
        food += add;
        System.out.println("В тарелку добавлено " + add + " еды");
    }

    public int getFood() {
        return food;
    }

    //Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    public void takeFood(int count) {
        if (food >= count) {
            food -= count;
            System.out.println("Из тарелки взято " + count + " еды");
        }
    }
}
