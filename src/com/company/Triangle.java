package com.company;

public class Triangle implements Figure {
    private final int side1;
    private final int side2;
    private final int side3;
    private String color;
    private String borderColor;

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getSquare() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
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
