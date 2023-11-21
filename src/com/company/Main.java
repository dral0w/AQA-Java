package com.company;

public class Main {

    public static void main(String[] args) {
        //Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
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

        //Задать для каждой фигуры цвет заливки и цвет границы.
        circle.setColor("red");
        circle.setBorderColor("black");

        rectangle.setColor("blue");
        rectangle.setBorderColor("yellow");

        triangle.setColor("orange");
        triangle.setBorderColor("green");

        //Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
        circle.getInformation();
        rectangle.getInformation();
        triangle.getInformation();
    }
}
