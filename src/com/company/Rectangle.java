package com.company;

public class Rectangle implements Figure {
    private final int side1;
    private final int side2;
    private String color;
    private String borderColor;

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2) * 2;
    }

    @Override
    public double getSquare() {
        return side1 * side2;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void getInformation() {
        System.out.println("Цвет заливки: " + color + "\n" + "Цвет границ: " + borderColor + "\n" +
                "Площадь: " + getSquare() + "\n" + "Периметр: " + getPerimeter());
    }
}
