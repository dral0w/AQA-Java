package com.company;

public class Circle implements Figure {
    private final int radius;
    private String color;
    private String borderColor;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public double getSquare() {
        return radius * radius * Math.PI;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void getInformation() {
        System.out.println("Цвет заливки: " + color + "\n" + "Цвет границ: " + borderColor + "\n" +
                "Площадь: " + getSquare() + "\n" + "Периметр: " + getPerimeter());
    }
}
