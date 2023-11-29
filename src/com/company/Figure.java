package com.company;

//Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
public interface Figure {
    double getPerimeter();

    double getSquare();

    String getColor();

    String getBorderColor();

    default void getInformation() {
        System.out.println("Цвет фигуры: " + getColor() + "\nЦвет границы: " + getBorderColor() +
                "\nПериметр: " + getPerimeter() + "\nПлощадь: " + getSquare() + "\n");
    }
}
