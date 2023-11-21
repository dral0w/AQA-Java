package com.company;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = new Cat[]{new Cat(), new Cat(), new Cat()};
        Cat.Plate plate = new Cat.Plate();
        plate.addFood(20);
        cats[0].eat(plate, 7);
        cats[1].eat(plate, 9);
        cats[2].eat(plate, 5);
        for (Cat cat : cats) {
            System.out.println(cat.isFull());
        }

        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(2, 4);
        Triangle triangle = new Triangle(7, 9, 14);

        circle.setColor("red");
        circle.setBorderColor("black");

        rectangle.setColor("blue");
        rectangle.setBorderColor("yellow");

        triangle.setColor("orange");
        triangle.setBorderColor("green");

        circle.getInformation();
        rectangle.getInformation();
        triangle.getInformation();
    }
}
